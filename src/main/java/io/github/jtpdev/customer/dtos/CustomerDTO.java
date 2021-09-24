package io.github.jtpdev.customer.dtos;

import io.github.jtpdev.customer.models.Customer;
import lombok.Data;

@Data
public class CustomerDTO implements DefaultDTO<Customer>{
    private Long id;
    private String name;
    private String lastName;
    private String description;

    public Customer toModel(){
        return new Customer(name, lastName, description);
    }
}
