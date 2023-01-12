package com.lifelong.study.consumer.mq;

import com.lifelong.study.common.api.beans.msg.MsgConst;
import com.lifelong.study.common.beans.message.BaseMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 *
 * @author: lin
 * @date: 2023/1/12
 */

@Slf4j
@Component
@RocketMQMessageListener(
        consumerGroup = "lls-consumer-group",
        topic = MsgConst.MSG_TOPIC,
        selectorExpression = MsgConst.MSG_TAG
)
public class ConsumeMsgListener implements RocketMQListener<BaseMsg> {

    @Override
    public void onMessage(BaseMsg baseMsg) {
        log.info(baseMsg.toString());
    }
}
