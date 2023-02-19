package edu.akanatbekuulu.rabbitmqprocessor.repository.message;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Message;
import edu.akanatbekuulu.rabbitmqprocessor.enums.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findAllByStatus(MessageStatus status);
    Optional<Message> findByIdAndStatus(Long id,MessageStatus status);
}
