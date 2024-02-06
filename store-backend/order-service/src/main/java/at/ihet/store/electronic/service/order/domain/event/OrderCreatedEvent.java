package at.ihet.store.electronic.service.order.domain.event;

import at.ihet.store.electronic.service.order.domain.Order;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record OrderCreatedEvent(Order order) {

    public OrderCreatedEvent(Order order) {
        this.order = Objects.requireNonNull(order);
    }
}
