package com.team.framenb.config;

import com.team.framenb.interceptor.RequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author haohao
 * @create 2017/10/22 下午10:19
 **/
public class WebConfiguration extends WebMvcConfigurerAdapter {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/*");
    }
}