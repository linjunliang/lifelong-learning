package com.lifelong.study.uc.ordinary.controller;

import com.lifelong.study.uc.ordinary.pojo.entity.UserEntity;
import com.lifelong.study.uc.ordinary.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户controller
 *
 * @author: lin
 * @date: 2023/3/5
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public List<UserEntity> list(){
        return userService.list();
    }
}
