package com.lifelong.study.common.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lifelong.study.common.pojo.entity.BaseEntity;
import com.lifelong.study.common.service.BaseService;

/**
 * BaseServiceImpl
 *
 * @author: lin
 * @date: 2023/3/4
 */
public class BaseServiceImpl<M extends BaseMapper<E>, E extends BaseEntity> extends ServiceImpl<M,E> implements BaseService<E> {

}