package com.lifelong.study.uc.ordinary.service.impl;

import com.lifelong.study.common.service.impl.BaseServiceImpl;
import com.lifelong.study.uc.ordinary.mapper.UserMapper;
import com.lifelong.study.uc.ordinary.pojo.entity.UserEntity;
import com.lifelong.study.uc.ordinary.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author: lin
 * @date: 2023/3/5
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserEntity> implements UserService {
}
