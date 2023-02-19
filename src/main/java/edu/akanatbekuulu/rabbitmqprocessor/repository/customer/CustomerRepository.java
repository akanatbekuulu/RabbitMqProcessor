package edu.akanatbekuulu.rabbitmqprocessor.repository.customer;

import edu.akanatbekuulu.rabbitmqprocessor.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
