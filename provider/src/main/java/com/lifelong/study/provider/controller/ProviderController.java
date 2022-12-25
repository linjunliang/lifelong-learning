package com.lifelong.study.provider.controller;

import com.lifelong.study.common.beans.vo.BaseVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 服务提供者接口
 *
 * @author lin
 * @date 2022/4/10
 */
@RestController
@RequestMapping("/provider/v1")
@RefreshScope
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/provide/{id}")
    public BaseVo provide(@PathVariable Integer id) {
        String mess = String.format("provider【%s】 say hi to u !!!", this.serverPort);
        BaseVo result = new BaseVo();
        result.setId(id);
        result.setCreateTime(new Date());
        result.setMess(mess);
        return result;
    }

}
