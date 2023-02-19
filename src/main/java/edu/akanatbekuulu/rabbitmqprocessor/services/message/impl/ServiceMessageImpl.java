package edu.akanatbekuulu.rabbitmqprocessor.services.message.impl;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Message;
import edu.akanatbekuulu.rabbitmqprocessor.enums.MessageStatus;
import edu.akanatbekuulu.rabbitmqprocessor.models.MessageModel;
import edu.akanatbekuulu.rabbitmqprocessor.repository.customer.CustomerRepository;
import edu.akanatbekuulu.rabbitmqprocessor.repository.message.MessageRepository;
import edu.akanatbekuulu.rabbitmqprocessor.services.message.ServiceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMessageImpl implements ServiceMessage {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void createMessage(MessageModel messageModel){
        Message message = Message.fromModel(messageModel);
        messageRepository.save(message);
    }

    @Override
    public List<Message> findAllWithStatusNew() {
      return messageRepository.findAllByStatus(MessageStatus.NEW);
    }

    @Override
    public void rollBack(Long id, MessageStatus oldStatus, MessageStatus newStatus) {
        Optional<Message>  message = messageRepository.findByIdAndStatus(id,oldStatus).orElseThrow(::new);
    }


}
