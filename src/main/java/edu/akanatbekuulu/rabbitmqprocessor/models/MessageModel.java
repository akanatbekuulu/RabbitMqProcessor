package edu.akanatbekuulu.rabbitmqprocessor.models;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Message;
import edu.akanatbekuulu.rabbitmqprocessor.enums.MessageType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MessageModel {

    private Boolean isRead;
    private String context;
    private Long customerId;
    private MessageType messageType;
    private LocalDateTime deliveryDate;

    public MessageModel fromEntity(Message message) throws IllegalArgumentException{
        if(message!=null){
        return MessageModel.builder()
                .isRead(message.getIsRead())
                .context(message.getContext())
                .customerId(message.getCustomerId())
                .messageType(message.getMessageType())
                .deliveryDate(message.getDeliveryDate())
                .build();
        }else throw new IllegalArgumentException("Unable to convert Message entity to Model due to message is null");
    }
}
