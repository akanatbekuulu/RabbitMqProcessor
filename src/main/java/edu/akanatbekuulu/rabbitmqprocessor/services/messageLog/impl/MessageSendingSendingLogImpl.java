package edu.akanatbekuulu.rabbitmqprocessor.services.messageLog.impl;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Message;
import edu.akanatbekuulu.rabbitmqprocessor.enums.MessageStatus;
import edu.akanatbekuulu.rabbitmqprocessor.services.customer.CustomerService;
import edu.akanatbekuulu.rabbitmqprocessor.services.message.ServiceMessage;
import edu.akanatbekuulu.rabbitmqprocessor.services.messageLog.MessageSendingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageSendingSendingLogImpl implements MessageSendingLogService {


    @Autowired
    private ServiceMessage serviceMessage;

    @Autowired
    private CustomerService customerService;

    @Override
    public void sendMessage(){
        List<Message> messages = serviceMessage.findAllWithStatusNew();
    };

    public void rollBack(Long id,MessageStatus oldStatus,MessageStatus newStatus){
        Optional<Message> message =
    }

}
