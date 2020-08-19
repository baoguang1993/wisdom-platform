package com.libaoguang.cn.principleproducer.constants;

public class QueueConstants {
    // 消息交换
    public static final String MESSAGE_EXCHANGE = "message.direct.myexchange";
    // 消息队列名称
    public static final String MESSAGE_QUEUE_NAME = "message.myqueue";
    // 消息路由键
    public static final String MESSAGE_ROUTE_KEY = "message.myroute";

    // 死信消息交换
    public static final String MESSAGE_EXCHANGE_DL = "message.direct.dlexchange";
    // 死信消息队列名称
    public static final  String MESSAGE_QUEUE_NAME_DL = "message.dlqueue";
    // 死信消息路由键
    public static final String MESSAGE_ROUTE_KEY_DL = "message.dlroute";
}
