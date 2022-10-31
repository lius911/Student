package com.student.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author li
 */
public class Mvcljq implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object log=request.getSession().getAttribute("log");
        if (log==null){
            request.setAttribute("msg" ,"账号或者密码错误");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
