package com.lifelong.study.common.api.beans.msg;

/**
 * 消息常量
 *
 * @author: lin
 * @date: 2023/1/12
 */
public class MsgConst {
    public static final String MSG_SPLIT = ":";
    public static final String MSG_TOPIC = "lls-provider-topic";
    public static final String MSG_TAG = "msg-tag";
    public static final String MSG_DESTINATION = MSG_TOPIC + MSG_SPLIT + MSG_TAG;
}
