package edu.akanatbekuulu.rabbitmqprocessor.entities;

import edu.akanatbekuulu.rabbitmqprocessor.enums.CustomerStatus;
import edu.akanatbekuulu.rabbitmqprocessor.enums.CustomerType;
import edu.akanatbekuulu.rabbitmqprocessor.models.CustomerModel;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity{

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CUSTOMER_TYPE")
    private CustomerType customerType;

    @Column(name = "STATUS")
    private CustomerStatus customerStatus;

    public Customer formModel(CustomerModel customerModel){
        if(customerModel != null){

        return Customer.builder()
                .firstName(customerModel.getFirstName())
                .lastName(customerModel.getLastName())
                .phoneNumber(customerModel.getPhoneNumber())
                .email(customerModel.getEmail())
                .customerType(customerModel.getCustomerType())
                .customerStatus(customerModel.getCustomerStatus())
                .build();
        }else throw new IllegalArgumentException("Unable to convert CustomerModel to Customer due to model is null");

    }
}
