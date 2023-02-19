package edu.akanatbekuulu.rabbitmqprocessor.entities;

import edu.akanatbekuulu.rabbitmqprocessor.enums.MessageStatus;
import edu.akanatbekuulu.rabbitmqprocessor.enums.MessageType;
import edu.akanatbekuulu.rabbitmqprocessor.models.MessageModel;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Message extends BaseEntity{

    @Column(name = "IS_READ", columnDefinition = "number(1) default 1")
    private Boolean isRead;

    @Column(name = "CONTEXT")
    private String context;

    @Column(name = "MESSAGE_TYPE")
    private MessageType messageType;

    @Column(name = "STATUS")
    private MessageStatus status;

    public static Message fromModel(MessageModel messageModel) throws IllegalArgumentException {
        if (messageModel != null) {
            return Message.builder()
                    .isRead(messageModel.getIsRead())
                    .context(messageModel.getContext())
                    .messageType(messageModel.getMessageType())
                    .build();
        } else throw new IllegalArgumentException("Unable to convert messageModel to Entity due to messageModel is null");
    }
}
