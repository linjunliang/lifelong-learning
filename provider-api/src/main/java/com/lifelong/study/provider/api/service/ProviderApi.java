package com.lifelong.study.provider.api.service;

import com.lifelong.study.common.api.beans.vo.BaseVo;
import com.lifelong.study.provider.api.beans.vo.ProviderApiVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 服务提供者Feign
 *
 * @author: lin
 * @date: 2022/4/10
 */
@FeignClient(name = "lls-provider", path = "/provider/api/v1")
public interface ProviderApi {

    /**
     * feign 调用服务消费
     *
     * @param id id
     * @return {@link BaseVo}
     */
    @GetMapping("/provide/{id}")
    ProviderApiVo provide(@PathVariable Integer id);
}
