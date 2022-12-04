package com.lin.lifelong.learning.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者controller
 *
 * @author: lin
 * @date: 2022/12/4
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @GetMapping("/{id}")
    public String id(@PathVariable("id") String id){
        return id;
    }

}
