package com.wong.upala.ai.config;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 实现国际化造作
 * @author upala
 */

public class ScoreMessage implements LocaleResolver {

    /**
     * 设置国际化
     * @param request 入参
     * @return 返回值
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String local = request.getParameter("local");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(local)) {
            String[] split = local.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
