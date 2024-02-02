package at.ihet.store.electronic.service.order.domain.event;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record OrderCreatedEvent(UUID orderId, BigDecimal amount) {

    public OrderCreatedEvent(UUID orderId, BigDecimal amount) {
        this.orderId = Objects.requireNonNull(orderId);
        this.amount = Objects.requireNonNull(amount);
    }

    public static OrderCreatedEvent of(final UUID orderId, final BigDecimal amount) {
        return new OrderCreatedEvent(orderId, amount);
    }
}
