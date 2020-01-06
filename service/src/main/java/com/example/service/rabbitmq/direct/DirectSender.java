package com.example.service.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 完全匹配
 */
@Component
public class DirectSender {

    //交换器名称
    private String exchange = "log.direct";
    //路又键
    private String routing = "error.info.routing.key";

    @Autowired
    private AmqpTemplate amqpTemplate;
    /**
     * 消息生产者
     */
    public void send(String msg) {
        amqpTemplate.convertAndSend(exchange,routing,msg);
    }
}
