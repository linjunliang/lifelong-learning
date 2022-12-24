package com.lifelong.learning.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lin
 * 消费者测试
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class LifelongLearningConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifelongLearningConsumerApplication.class, args);
    }

}
