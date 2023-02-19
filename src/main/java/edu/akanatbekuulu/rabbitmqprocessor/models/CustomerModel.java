package edu.akanatbekuulu.rabbitmqprocessor.models;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Customer;
import edu.akanatbekuulu.rabbitmqprocessor.enums.CustomerStatus;
import edu.akanatbekuulu.rabbitmqprocessor.enums.CustomerType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerModel {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private CustomerType customerType;
    private CustomerStatus customerStatus;

    public CustomerModel fromEntity(Customer customer){
        if(customer!=null){
           return CustomerModel.builder()
                   .firstName(customer.getFirstName())
                   .lastName(customer.getLastName())
                   .phoneNumber(customer.getPhoneNumber())
                   .email(customer.getEmail())
                   .address(customer.getAddress())
                   .customerType(customer.getCustomerType())
                   .customerStatus(customer.getCustomerStatus())
                   .build();
        } else throw new IllegalArgumentException("Unable to convert Customer entity to model due to entity is null");
    }

}
