package at.ihet.store.electronic.service.order.domain.event;

import java.util.Objects;
import java.util.UUID;

public class OrderCreatedEvent {

    public final UUID orderId;

    public OrderCreatedEvent(UUID orderId) {
        this.orderId = Objects.requireNonNull(orderId);
    }

    public static OrderCreatedEvent of(final UUID orderId) {
        return new OrderCreatedEvent(orderId);
    }
}
