package edu.akanatbekuulu.rabbitmqprocessor.consumer;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Message;
import edu.akanatbekuulu.rabbitmqprocessor.untils.ExchangeConstants;
import edu.akanatbekuulu.rabbitmqprocessor.untils.QueueConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "rabbitmq-config",matchIfMissing = true)
public class RabbitMqConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = QueueConstants.MY_QUEUE_NOTIFICATIONS, durable = "true"),
            exchange = @Exchange(value = ExchangeConstants.MY_EXCHANGE_NOTIFICATIONS, type = ExchangeTypes.FANOUT)
    ))
    public void receiveMessageAndSave(List<Message> message) {


    }
}
