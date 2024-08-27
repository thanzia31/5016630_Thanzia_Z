package com.example.BookStoreAPI.controller;

import com.example.BookStoreAPI.dto.CustomerDTO;
import com.example.BookStoreAPI.mapper.CustomerMapper;
import com.example.BookStoreAPI.model.Customer;
import com.example.BookStoreAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        List<CustomerDTO> customerDTOs = customers.stream()
                                                 .map(CustomerMapper.INSTANCE::toDTO)
                                                 .collect(Collectors.toList());
        return ResponseEntity.ok(customerDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            CustomerDTO customerDTO = CustomerMapper.INSTANCE.toDTO(customer);
            return ResponseEntity.ok(customerDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        Customer savedCustomer = customerService.addCustomer(customer);
        CustomerDTO savedCustomerDTO = CustomerMapper.INSTANCE.toDTO(savedCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") Long id, @RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        customer.setId(id);
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        if (updatedCustomer != null) {
            CustomerDTO updatedCustomerDTO = CustomerMapper.INSTANCE.toDTO(updatedCustomer);
            return ResponseEntity.ok(updatedCustomerDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
