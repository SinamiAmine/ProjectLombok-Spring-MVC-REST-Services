package com.sinami.spring6restmvc.services;

import com.sinami.spring6restmvc.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface CustomerService {
    public List<Customer> getAll();
    public Customer getById(UUID id);

    Customer addNewCustomer(Customer customer);

    void updateBeerById(UUID customerId, Customer customer);
}
