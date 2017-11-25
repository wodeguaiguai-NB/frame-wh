package com.team.framenb.controller;

import com.google.gson.GsonBuilder;
import com.team.framenb.entity.User;
import com.team.framenb.service.UserService;
import com.team.framenb.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用于测试
 *
 * @author haohao
 * @create 2017/10/22 下午9:50
 **/
@RestController
@RequestMapping("/")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private UserService userService;

    @ApiOperation(value = "测试接口",notes = "测试restful接口")
    @GetMapping("/hello/{name}")
    public void hello(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) throws Exception{

        if(StringUtils.isBlank(name)){
            name = "haohao";
        }
        logger.info("测试log4j==="+name);
        response.getWriter().write("Hello "+name+"!");
    }

    @ApiOperation(value = "添加人员",notes = "添加人员信息")
    @PostMapping("/user/add")
    public void add(@RequestBody UserVo userVo, HttpServletResponse response) throws Exception{
        User user = this.userService.addUser(userVo.getName(),userVo.getAge());

        response.getWriter().write(new GsonBuilder().create().toJson(user));

    }


    @ApiOperation(value = "查找人员",notes = "根据url中的ID获取人员信息")
    @GetMapping("/user/find/{id}")
    public void findUserByName(@PathVariable Integer id ,HttpServletRequest request, HttpServletResponse response) throws Exception{
        User user = this.userService.findUserById(id);
        response.getWriter().write(new GsonBuilder().create().toJson(user));
    }

    @ApiOperation(value = "获取人员列表", notes = "根据url中的name查找人员列表")
    @GetMapping("/user/findAll/{name}")
    public void findAllUserByName(@PathVariable String name ,HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<User> users = this.userService.findAllUserByName(name);

        response.getWriter().write(new GsonBuilder().create().toJson(users));
    }
}
