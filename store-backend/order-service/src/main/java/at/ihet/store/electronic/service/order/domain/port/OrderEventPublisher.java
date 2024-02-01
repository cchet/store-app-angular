package at.ihet.store.electronic.service.order.domain.port;

import at.ihet.store.electronic.service.order.domain.event.OrderCreatedEvent;

public interface OrderEventPublisher {

    void publishOrderCreated(OrderCreatedEvent event);
}
