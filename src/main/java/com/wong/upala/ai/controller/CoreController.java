package com.wong.upala.ai.controller;

import com.alibaba.fastjson.JSONArray;
import com.wong.upala.ai.entity.SystemManageOne;
import com.wong.upala.ai.service.MenuService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/28 19:14
 *  @version 0.0.1
 *****************************/

@Controller
@RequestMapping("/score")
@Log4j2
public class CoreController {

	@Autowired
	private MenuService menuService;

	/**
	 * 菜单数据
	 * @return 返回值
	 */
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	@ResponseBody
	public String menu() {
		List<SystemManageOne> list = new ArrayList<>();
		SystemManageOne manageOne = menuService.querySystemByType();
		list.add(manageOne);
		String jsonString = JSONArray.toJSONString(list);
		log.info(jsonString);
		return jsonString;
	}

}
