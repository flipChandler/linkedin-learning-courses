package com.linkedin.events.ticket;

import com.linkedin.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class TicketFailedOrderListener {

    private final TicketService ticketService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void onOrderCompleted(OrderCompletedEvent event) {
        ticketService.createTicket(event.getOrder());
    }

    // course Software Architecture: DDD with Allen Holub
}
