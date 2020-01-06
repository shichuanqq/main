package com.example.service.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 模糊匹配
 */
@Component
public class TopicSender {

    private String exchange = "log.topic";

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        amqpTemplate.convertAndSend(exchange, "user.log.info", "user" + msg);

        amqpTemplate.convertAndSend(exchange, "name.log.info", "name" + msg);

        amqpTemplate.convertAndSend(exchange, "name.log.error", "error" + msg);

//        amqpTemplate.convertAndSend(exchange, "user.log.debug", "debug" + msg);
//        amqpTemplate.convertAndSend(exchange, "user.log.warn", "warn" + msg);
//        amqpTemplate.convertAndSend(exchange, "user.log.error", "error" + msg);

    }
}
