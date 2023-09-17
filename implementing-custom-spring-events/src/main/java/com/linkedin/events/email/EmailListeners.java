package com.linkedin.events.email;

import com.linkedin.events.customer.CustomerRegisteredEvent;
import com.linkedin.events.customer.CustomerRemovedEvent;
import com.linkedin.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EmailListeners {

    private final EmailService emailService;

    @EventListener
    public void onRegisterEvent(CustomerRegisteredEvent event) {
        emailService.sendRegisterEmail(event.getCustomer());
    }

    @EventListener
    public void onCustomerRemovedEvent(CustomerRemovedEvent event) {
        emailService.sendCustomerRemovedEmail(event.getCustomer());
    }

    // if a rollback happens in OrderService.placeOrder, no email will be sent
    // AFTER_COMMIT is the default phase
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onOrderCompletedEvent(OrderCompletedEvent event) {
        emailService.sendOrderEmail(event.getOrder());
    }
}
