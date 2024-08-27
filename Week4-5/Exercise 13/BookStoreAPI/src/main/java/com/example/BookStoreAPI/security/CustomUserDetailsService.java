package com.example.BookStoreAPI.security;

import com.example.BookStoreAPI.model.Customer;
import com.example.BookStoreAPI.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if (!customer.isPresent()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        Customer customerData = customer.get();
        return User.builder()
                .username(customerData.getEmail())
                .password(customerData.getPassword())
                .roles("USER") // You can add roles dynamically from customer data if needed
                .build();
    }
}
