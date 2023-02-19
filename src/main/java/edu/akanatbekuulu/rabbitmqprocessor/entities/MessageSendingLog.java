package edu.akanatbekuulu.rabbitmqprocessor.entities;

import edu.akanatbekuulu.rabbitmqprocessor.enums.MessageSendingStatus;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageSendingLog extends BaseEntity{

    private LocalDateTime deliveryDate;

    private Long messageId;

    private Long customerId;

    private MessageSendingStatus status;

    private String description;

}
