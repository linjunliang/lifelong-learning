package com.lin.lifelong.learning.consumer.api;

import com.lin.lifelong.learning.common.beans.vo.BaseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 服务提供者Feign
 *
 * @author: lin
 * @date: 2022/4/10
 */
@FeignClient("lifelong-learning-provider")
public interface ProviderApi {

    /**
     * feign 调用服务消费
     * @param id id
     * @return {@link BaseVo}
     */
    @GetMapping("/provider/provide/{id}")
    BaseVo provide(@PathVariable Integer id);
}
