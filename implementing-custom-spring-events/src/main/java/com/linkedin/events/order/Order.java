package com.linkedin.events.order;

import com.linkedin.events.customer.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private OrderStatus status;

    @Column(length = 40)
    private String message;

    @ManyToOne
    private Customer customer;

    public Order(OrderStatus status) {
        this.status = status;
    }

    public enum OrderStatus {
        SAVED, COMPLETED
    }
}
