package at.ihet.store.electronic.service.payment.application.command;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record StartPaymentRequest(UUID orderId, BigDecimal amount) {

    public StartPaymentRequest(UUID orderId, final BigDecimal amount) {
        this.orderId = Objects.requireNonNull(orderId);
        this.amount = Objects.requireNonNull(amount);
    }
}
