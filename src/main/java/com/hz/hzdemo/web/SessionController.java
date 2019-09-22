package com.hz.hzdemo.web;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by zhoumingbing on 2019-05-16
 */
@RestController
public class SessionController {

    private static final String COOKIE_NAME = "set_cookie";

    @RequestMapping(value = "/session")
    public void session(HttpServletRequest request) {
        System.out.println(request.getSession().getId());
    }

    @RequestMapping(value = "/getSessionValue")
    public String getSessionValue(HttpServletRequest request) {
        return request.getSession().getAttribute(COOKIE_NAME).toString();
    }

    @RequestMapping(value = "/getCookieValue")
    public String getCookieValue(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (StringUtils.equals(cookie.getName(), COOKIE_NAME)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    @RequestMapping(value = "/setCookie")
    public void setCookie(HttpServletResponse response) {
        response.addCookie(new Cookie(COOKIE_NAME, "cookie_test_value"));
    }

}
