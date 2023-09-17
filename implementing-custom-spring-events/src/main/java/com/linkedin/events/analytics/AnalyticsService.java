package com.linkedin.events.analytics;

import com.linkedin.events.customer.Customer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

@Slf4j
@Service
public class AnalyticsService {

    @SneakyThrows
    public void registerNewCustomer(Customer customer) {
        log.info("calling analytics service for customer {}", customer);
        sleep(5_000);
    }
}
