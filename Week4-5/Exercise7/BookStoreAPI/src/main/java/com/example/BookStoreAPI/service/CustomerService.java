package com.example.BookStoreAPI.service;

import com.example.BookStoreAPI.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private List<Customer> customerList = new ArrayList<>();
    private long idCounter = 1;

    public Customer addCustomer(Customer customer) {
        customer.setId(idCounter++);
        customerList.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customerList;
    }
}
