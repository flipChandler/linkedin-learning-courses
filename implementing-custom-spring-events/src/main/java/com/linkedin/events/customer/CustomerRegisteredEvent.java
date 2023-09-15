package com.linkedin.events.customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CustomerRegisteredEvent { // extends ApplicationEvent < Spring version 4.2

    // this event must contain a customer object, that will be sent to other services
    private final Customer customer;
}
