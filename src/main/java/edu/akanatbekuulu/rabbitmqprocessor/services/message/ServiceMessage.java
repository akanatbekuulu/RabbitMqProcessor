package edu.akanatbekuulu.rabbitmqprocessor.services.message;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Message;
import edu.akanatbekuulu.rabbitmqprocessor.enums.MessageStatus;
import edu.akanatbekuulu.rabbitmqprocessor.models.MessageModel;

import java.util.List;

public interface ServiceMessage {
    void createMessage(MessageModel messageModel);

    List<Message> findAllWithStatusNew();
    void rollBack(Long id, MessageStatus oldStatus, MessageStatus newStatus);
}
