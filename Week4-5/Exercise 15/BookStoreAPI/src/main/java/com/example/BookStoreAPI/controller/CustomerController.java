package com.example.BookStoreAPI.controller;

import com.example.BookStoreAPI.dto.CustomerDTO;
import com.example.BookStoreAPI.mapper.CustomerMapper;
import com.example.BookStoreAPI.model.Customer;
import com.example.BookStoreAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/customers")
@Tag(name = "Customers", description = "API for managing customers in the bookstore")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers in the bookstore")
    public ResponseEntity<List<EntityModel<CustomerDTO>>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        List<EntityModel<CustomerDTO>> customerDTOs = customers.stream()
            .map(customer -> {
                CustomerDTO dto = CustomerMapper.INSTANCE.toDTO(customer);
                EntityModel<CustomerDTO> entityModel = EntityModel.of(dto);
                entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel());
                return entityModel;
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(customerDTOs);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Get customer by ID", description = "Retrieve a single customer by their ID")
    public ResponseEntity<EntityModel<CustomerDTO>> getCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(c -> {
            CustomerDTO dto = CustomerMapper.INSTANCE.toDTO(c);
            EntityModel<CustomerDTO> entityModel = EntityModel.of(dto);
            entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(c.getId())).withSelfRel());
            entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getAllCustomers()).withRel("all-customers"));
            return ResponseEntity.ok(entityModel);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Operation(summary = "Add a new customer", description = "Add a new customer to the bookstore")
    public ResponseEntity<EntityModel<CustomerDTO>> addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        Customer savedCustomer = customerService.addCustomer(customer);
        CustomerDTO savedCustomerDTO = CustomerMapper.INSTANCE.toDTO(savedCustomer);
        EntityModel<CustomerDTO> entityModel = EntityModel.of(savedCustomerDTO);
        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(savedCustomer.getId())).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(entityModel);
    }

    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Operation(summary = "Update an existing customer", description = "Update the details of an existing customer by ID")
    public ResponseEntity<EntityModel<CustomerDTO>> updateCustomer(@PathVariable("id") Long id, @RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        customer.setId(id);
        Optional<Customer> updatedCustomer = customerService.updateCustomer(id, customer);
        return updatedCustomer.map(c -> {
            CustomerDTO updatedCustomerDTO = CustomerMapper.INSTANCE.toDTO(c);
            EntityModel<CustomerDTO> entityModel = EntityModel.of(updatedCustomerDTO);
            entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(c.getId())).withSelfRel());
            return ResponseEntity.ok(entityModel);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer", description = "Delete a customer by their ID")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
