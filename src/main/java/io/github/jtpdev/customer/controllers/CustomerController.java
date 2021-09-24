package io.github.jtpdev.customer.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtpdev.customer.dtos.CustomerDTO;
import io.github.jtpdev.customer.models.Customer;
import io.github.jtpdev.customer.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository repository;
    
    @GetMapping("/customer")
    List<Customer> list() {
        return repository.findAll();
    }

    @PostMapping("/customer")
    Customer save(@RequestBody CustomerDTO newCustomer) {
        return repository.save(newCustomer.toModel());
    }

    @GetMapping("/customer/{id}")
    Optional<Customer> get(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/customer/{id}")
    Customer put(@RequestBody CustomerDTO newCustomer, @PathVariable Long id) {

        return repository.findById(id).map(customer -> {
            customer.setDescription(newCustomer.getDescription());
            customer.setLastName(newCustomer.getLastName());
            customer.setName(newCustomer.getName());
            return repository.save(customer);
        }).orElseGet(() -> {
            newCustomer.setId(id);
            return save(newCustomer);
        });
    }

    @DeleteMapping("/customer/{id}")
    void delete(@PathVariable Long id) {
        Optional<Customer> foundCustomer = repository.findById(id);
        if (foundCustomer.isPresent()) {
            Customer customer = foundCustomer.get();
            repository.delete(customer);
        }
    }
}
