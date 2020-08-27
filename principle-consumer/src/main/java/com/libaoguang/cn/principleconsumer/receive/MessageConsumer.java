package com.libaoguang.cn.principleconsumer.receive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;

import org.springframework.stereotype.Component;

/**
value 绑定的队列名称 autoDelete
*Exchange value:为交换器起个名称 type 消息投递策略
* key: 在 topic 方式下，这个就是我们熟知的 routingKey
 */

/**
 * RabbitListener注解的参数queues不是支持多个队列，当 RabbitListener的参数指定多个 queue 时，每个 queue 是不是启动不同的线程去消费各自的 queue，如果不是，需要怎么设置才能做到每个 queue 单独线程消费？
 */
@Component
//@RabbitListener(
//        bindings = @QueueBinding(
//                value = @Queue(value = "message.queue",autoDelete = "true"),
//                exchange = @Exchange(value = "message.myexchange", type = ExchangeTypes.DIRECT),
//                key = "message.myrote"
//        )
//)
@RabbitListener(queues = "${myqueue.queuename}")
public class MessageConsumer {
    private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @RabbitHandler
    public void recieved(String msg) {

        logger.info("[message] recieved message: " + msg);
    }
}
