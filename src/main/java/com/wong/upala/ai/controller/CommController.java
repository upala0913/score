package com.wong.upala.ai.controller;

import com.wong.upala.ai.utils.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/16 1:17
 *  @version 0.0.1
 *****************************/

@Controller
@RequestMapping("/comm")
public class CommController {

	/**
	 * 获取验证码
	 * @return 返回值
	 */
	@RequestMapping(value="/getKey", method=RequestMethod.GET)
	@ResponseBody
	public String getKey() {
		return MapUtils.getMap().get("key");
	}

}
