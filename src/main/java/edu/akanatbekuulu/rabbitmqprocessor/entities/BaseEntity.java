package edu.akanatbekuulu.rabbitmqprocessor.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @PrePersist
    public void prePersist(){
        this.createdDate = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        this.updatedDate = LocalDateTime.now();
    }

    @PreRemove
    public void preDelete(){
        this.deletedDate = LocalDateTime.now();
    }


}
