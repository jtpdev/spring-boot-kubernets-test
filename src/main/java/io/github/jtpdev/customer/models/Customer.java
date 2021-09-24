package io.github.jtpdev.customer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    public Customer(String name, String lastName, String description) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String lastName;
    @Column(length = 3000)
    private String description;
}
