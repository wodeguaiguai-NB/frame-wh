package com.team.framenb.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于测试
 *
 * @author haohao
 * @create 2017/10/22 下午9:50
 **/
@RestController
@RequestMapping("/login")
public class TestController {

    Logger logger = Logger.getLogger(TestController.class);
    @GetMapping("/hello/{name}")
    public void hello(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) throws Exception{

        if(StringUtils.isBlank(name)){
            name = "haohao";
        }
        logger.info("测试log4j==="+name);
        response.getWriter().write("Hello "+name+"!");
    }
}
