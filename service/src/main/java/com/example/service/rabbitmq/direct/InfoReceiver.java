package com.example.service.rabbitmq.direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class InfoReceiver {

    /**
     * 接受消息
     * RabbitListener
     * bindings绑定队列
     * QueueBinding详细
     * value 队列名称
     * autoDelete 是否是一个可删除的临时队列
     * Exchange 为交换器起一个名称
     * type 指定具体的交换器的类型
     * key 路由规则
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "log.info",autoDelete = "true"),
            exchange = @Exchange(value = "log.direct",type = ExchangeTypes.DIRECT),
            key = "log.info.routing.key"
            ))
    public void process(String msg) {
        System.out.println("log.info--" + msg);
    }
}
