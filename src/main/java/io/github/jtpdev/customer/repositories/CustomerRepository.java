package io.github.jtpdev.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.jtpdev.customer.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
