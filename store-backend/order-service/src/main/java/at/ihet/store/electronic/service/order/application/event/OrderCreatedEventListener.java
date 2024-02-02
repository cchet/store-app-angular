package at.ihet.store.electronic.service.order.application.event;

import at.ihet.store.electronic.service.order.domain.event.OrderCreatedEvent;
import at.ihet.store.electronic.service.order.domain.port.OrderEventPublisher;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class OrderCreatedEventListener {

    private final Logger log;
    private final OrderEventPublisher orderEventPublisher;

    @Autowired
    OrderCreatedEventListener(Logger log, OrderEventPublisher orderEventPublisher) {
        this.log = log;
        this.orderEventPublisher = orderEventPublisher;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    void publishOrderCreatedEvent(final OrderCreatedEvent event) {
        log.info("Order created with id: " + event.orderId());
        orderEventPublisher.publishOrderCreated(event);
    }
}
