package com.wong.upala.ai.controller;

import com.wong.upala.ai.entity.Admin;
import com.wong.upala.ai.service.LoginService;
import com.wong.upala.ai.utils.MapUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/16 20:27
 *  @version 0.0.1
 *****************************/

@Controller
@RequestMapping("/login")
@Log4j2
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 获取用户信息
	 * @param admin 入参
	 * @return 返回值
	 */
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	@ResponseBody
	public boolean loginAdmin(@Validated({Admin.Add.class}) @RequestBody Admin admin, BindingResult result, HttpSession session) {
		log.info("获取的用户的信息：{}，校验信息：{}", admin, MapUtils.resultInfo(result));
		Admin adm = loginService.queryAdmin(admin);
		session.setAttribute("admin", adm);
		return null != adm;
	}

	/**
	 * 退出
	 * @param session 入参
	 * @return 返回值
	 */
	@RequestMapping(value="/out", method=RequestMethod.POST)
	@ResponseBody
	public boolean logout(HttpSession session) {
		session.invalidate();
		return true;
	}

}
