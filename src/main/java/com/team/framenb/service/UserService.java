package com.team.framenb.service;

import com.team.framenb.dao.UserDaoImpl;
import com.team.framenb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user service
 *
 * @author haohao
 * @create 2017/10/31 下午11:32
 **/
@Service
public class UserService {

    @Autowired
    private UserDaoImpl userDao;

    public User findUserByName(String name){
        return this.userDao.findByName(name);
    }

    public User findUserById(Integer userId){
        return this.userDao.findById(userId);
    }
    public User addUser(String name,Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);

       return this.userDao.save(user);
    }

    public List<User> findAllUserByName(String name){
        return this.userDao.findAllByName(name);
    }
}
