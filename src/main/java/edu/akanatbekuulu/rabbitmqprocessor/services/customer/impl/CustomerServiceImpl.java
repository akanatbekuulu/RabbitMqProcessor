package edu.akanatbekuulu.rabbitmqprocessor.services.customer.impl;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Customer;
import edu.akanatbekuulu.rabbitmqprocessor.models.CustomerModel;
import edu.akanatbekuulu.rabbitmqprocessor.repository.customer.CustomerRepository;
import edu.akanatbekuulu.rabbitmqprocessor.services.customer.CustomerService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerModel customerModel) {
        Customer customer = new Customer();
        customer.formModel(customerModel);
        customerRepository.save(customer);
    }
}
