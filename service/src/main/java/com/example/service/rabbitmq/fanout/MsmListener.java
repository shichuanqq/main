package com.example.service.rabbitmq.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsmListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order.msm", autoDelete = "true"),
            exchange = @Exchange(value = "order.fanout", type = ExchangeTypes.FANOUT)
    ))
    public void process(String msg) {
        System.out.println("sms msg--" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order.email", autoDelete = "true"),
            exchange = @Exchange(value = "order.fanout", type = ExchangeTypes.FANOUT)
    ))
    public void process1(String msg) {
        System.out.println("email msg--" + msg);
    }
}
