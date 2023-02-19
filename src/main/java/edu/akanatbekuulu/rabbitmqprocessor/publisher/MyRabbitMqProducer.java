package edu.akanatbekuulu.rabbitmqprocessor.publisher;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@RequiredArgsConstructor
@Slf4j
public class MyRabbitMqProducer {
    @Resource(name = "myRabbitMqTemplate")
    private final RabbitTemplate rabbitDeliveryTemplate;

    public void sendMessage(Message message){
        if(message == null){
            throw new IllegalArgumentException("message can not be null!!!");
        }
            rabbitDeliveryTemplate.convertAndSend(message);
    }

}
