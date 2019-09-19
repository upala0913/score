package com.wong.upala.ai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*****************************
 *  @author 王鹏
 *  @since 2019/7/26 23:24
 *  @version 0.0.1
 *****************************/

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 加载页面
	 * @param registry 入参
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/upala/scoreIndex.html").setViewName("scoreIndex");
		registry.addViewController("/scoreCore.html").setViewName("scoreCore.html");
		registry.addViewController("/stuManage.html").setViewName("manage/stuManage.html");
		registry.addViewController("/scoreManage.html").setViewName("manage/scoreManage.html");
		registry.addViewController("/teachManage.html").setViewName("manage/teachManage.html");
		registry.addViewController("/userManage.html").setViewName("manage/userManage.html");
		registry.addViewController("/roleManage.html").setViewName("manage/roleManage.html");
		registry.addViewController("/menuManage.html").setViewName("manage/menuManage.html");
	}

	/**
	 * 加载静态资源
	 * @param registry 入参
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	/**
	 * 注册拦截器
	 * @param registry 入参
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ScoreInterceptor()).addPathPatterns("/**").excludePathPatterns(
				"/upala/scoreIndex.html",
				"/comm/getKey",
				"/login/admin",
				"/static/**",
				"/score/menu"
		);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new ScoreMessage();
	}

}
