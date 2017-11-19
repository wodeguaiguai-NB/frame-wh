package com.team.framenb.interceptor;

import org.apache.commons.lang3.time.DateFormatUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *  拦截器：用于记录请求相应信息
 * @author haohao
 * @create 2017/10/22 下午10:12
 **/
public class RequestInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("===请求处理开始==="+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {


        logger.info("===请求处理结束==="+ DateFormatUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
    }
}
