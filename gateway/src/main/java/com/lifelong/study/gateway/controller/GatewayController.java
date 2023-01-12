package com.lifelong.study.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GatewayController
 *
 * @author: lin
 * @date: 2022/12/24
 */
@RestController
@RequestMapping("/v1/gateway")
public class GatewayController {

    @GetMapping("/hello")
    public String hello() {
        return "hello gateway";
    }

}
