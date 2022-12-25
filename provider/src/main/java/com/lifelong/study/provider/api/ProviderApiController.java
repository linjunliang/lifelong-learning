package com.lifelong.study.provider.api;

import com.lifelong.study.provider.api.beans.vo.ProviderApiVo;
import com.lifelong.study.provider.api.service.ProviderApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * ApiController
 *
 * @author: lin
 * @date: 2022/12/25
 */
@RestController
@RequestMapping("/provider/api/v1")
@RefreshScope
public class ProviderApiController implements ProviderApi {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String serverName;

    @Override
    @GetMapping("/provide/{id}")
    public ProviderApiVo provide(@PathVariable Integer id) {
        String mess = String.format("provider api【%s】 say hi to u !!!", this.serverPort);
        ProviderApiVo result = new ProviderApiVo();
        result.setId(id);
        result.setCreateTime(new Date());
        result.setProviderName(serverName);
        result.setMess(mess);
        return result;
    }
}
