package com.linkedin.events.customer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomerRemovedEvent {

    private final Customer customer;
}
