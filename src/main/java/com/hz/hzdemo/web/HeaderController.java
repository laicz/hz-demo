package com.hz.hzdemo.web;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by zhoumingbing on 2019-05-21
 */
@RestController
public class HeaderController {

    @RequestMapping(value = "/header")
    public String header(HttpServletRequest request, HttpServletResponse response, String headerName) {
        response.addHeader("Set-Cookie", "Path=/; HttpOnly");
        response.addHeader("test_add_header", "header_value_1");
        response.addCookie(new Cookie(headerName, "cookie_value1"));
        return request.getHeader(headerName);
    }

    @RequestMapping(value = "/getHeader")
    public String getHeader(HttpServletResponse response, HttpServletRequest request, String name) {
        return request.getHeader(name);
    }

    @RequestMapping(value = "/getCookie")
    public String getCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (StringUtils.equals(cookie.getName(), name)) {
                return cookie.getValue();
            }
        }
        return "";
    }
}
