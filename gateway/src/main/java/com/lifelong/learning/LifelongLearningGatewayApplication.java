package com.lifelong.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Lifelong Learning Gateway
 *
 * @author: lin
 * @date: 2022/12/24
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LifelongLearningGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifelongLearningGatewayApplication.class, args);
    }
}
