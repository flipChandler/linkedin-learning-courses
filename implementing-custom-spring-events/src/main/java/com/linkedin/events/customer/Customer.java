package com.linkedin.events.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;
    private boolean newsletter;

    @Column(columnDefinition = "DECIMAL(2)")
    private BigDecimal rewardPoints;

    public Customer(String email) {
        this.email = email;
    }
}
