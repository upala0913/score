package com.wong.upala.ai.config;

import com.wong.upala.ai.entity.Admin;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*****************************
 *  @author 王鹏
 *  @since 2019/8/23 21:26
 *  @version 0.0.1
 *****************************/

@Log4j2
public class ScoreInterceptor implements HandlerInterceptor {

	/**
	 * 配置拦截器
	 * @param request 入参
	 * @param response 入参
	 * @param handler 入参
	 * @return 返回值
	 * @throws Exception 抛出异常
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		log.info("用户信息：{}", admin);
		if (null != admin) {
			return true;
		} else {
			response.sendRedirect("/upala/scoreIndex.html");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
	}

}
