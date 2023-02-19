package edu.akanatbekuulu.rabbitmqprocessor.services.customer;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Customer;
import edu.akanatbekuulu.rabbitmqprocessor.models.CustomerModel;

public interface CustomerService {
    void createCustomer(CustomerModel customerModel);
}
