package com.lifelong.study.gateway.config.sentinel;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 使用Nacos配置规则
 *
 * @author: lin
 * @date: 2023/1/13
 */
@Configuration
@Slf4j
public class SentinelNacosDatasourceConfiguration {

    @Value("${spring.cloud.nacos.config.server-addr}")
    private String remoteAddress;

    @Value("${spring.cloud.nacos.config.group}")
    private String groupId;

    private static final String DATA_ID = "lls-sentinel-datasource";

    @PostConstruct
    public void init() {
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, DATA_ID,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }

}
