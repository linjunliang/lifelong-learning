package com.lifelong.study.common.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Mybatis系统扩展自动填充
 * @author: lin
 * @date: 2023-03-06
 */
@Component
@Slf4j
public class SysCustomMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            this.setFieldValByName("createUser", "SYS", metaObject);
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("updateUser", "SYS", metaObject);
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("isDeleted", 0, metaObject);
        } catch (ReflectionException ex) {
            log.error("mybatis 填充字段异常", ex);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            this.setFieldValByName("updateUser", "SYS", metaObject);
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        } catch (ReflectionException ex) {
            log.error("mybatis 填充字段异常", ex);
        }

    }
}