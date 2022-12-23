package com.lin.lifelong.learning.consumer.controller;

import com.lin.lifelong.learning.common.beans.vo.BaseVo;
import com.lin.lifelong.learning.consumer.api.ProviderApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 消费者controller
 *
 * @author: lin
 * @date: 2022/12/4
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private ProviderApi providerApi;

    @GetMapping("/{id}")
    public BaseVo id(@PathVariable("id") Integer id) {
        return providerApi.provide(id);
    }

}
