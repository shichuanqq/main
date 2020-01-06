package com.example.service.rabbitmq.direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ErrorReceiver {

    /**
     * 接受消息
     * RabbitListener
     * bindings绑定队列
     * QueueBinding详细
     * value 队列名称
     * autoDelete 是否是一个可删除的临时队列     设置成false的时候，当服务重启的时候，会将重启过程中未消费的数据消费掉，不会造成消息的丢失
     * Exchange 为交换器起一个名称
     * type 指定具体的交换器的类型
     * key 路由规则
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "error.info",autoDelete = "true"),
            exchange = @Exchange(value = "log.direct",type = ExchangeTypes.DIRECT),
            key = "error.info.routing.key"
            ))
    public void process(String msg) {
        System.out.println("error.info--" + msg);
        throw new RuntimeException();
    }
}
