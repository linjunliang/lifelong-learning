package com.lifelong.study.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户中心启动类
 *
 * @author: lin
 * @date: 2023/3/4
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.lifelong.study.uc.*.mapper"})
public class LifelongStudyUcApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifelongStudyUcApplication.class, args);
    }

}
