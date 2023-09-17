package com.linkedin.events.analytics;

import com.linkedin.events.customer.Customer;
import com.linkedin.events.customer.CustomerRegisteredEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnalyticsCustomerRegisteredListener {

    private final AnalyticsService analyticsService;

    // this is Async because registerNewCustomer in AnalyticsService taks 5 seconds (too long)
    @Async
    @EventListener
    public void onRegisterEvent(CustomerRegisteredEvent event) {
        analyticsService.registerNewCustomer(event.getCustomer());
    }
}
