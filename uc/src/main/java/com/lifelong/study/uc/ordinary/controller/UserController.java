package com.lifelong.study.uc.ordinary.controller;

import com.lifelong.study.uc.ordinary.pojo.converter.UserConverter;
import com.lifelong.study.uc.ordinary.pojo.dto.UserDTO;
import com.lifelong.study.uc.ordinary.pojo.entity.UserEntity;
import com.lifelong.study.uc.ordinary.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<UserDTO> list(){
        return userService.list().stream().map(UserConverter.INSTANCE::entity2Dto).collect(Collectors.toList());
    }
}
