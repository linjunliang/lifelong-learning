package com.lifelong.study.uc.ordinary.controller;

import com.lifelong.study.uc.ordinary.pojo.converter.UserConverter;
import com.lifelong.study.uc.ordinary.pojo.dto.UserDTO;
import com.lifelong.study.uc.ordinary.pojo.entity.UserEntity;
import com.lifelong.study.uc.ordinary.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<UserDTO> list() {
        return UserConverter.INSTANCE.entity2Dto(userService.list());
    }

    @GetMapping("/save")
    public void save() {
        int size = 10;
        List<UserEntity> userEntities = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            UserEntity user = UserEntity.builder()
                    .username("user" + i)
                    .pwd("pwd" + i)
                    .build();

            userEntities.add(user);
        }

        userService.saveBatch(userEntities);

    }
}
