package at.ihet.store.electronic.service.payment.inbound.amqp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentEvent(UUID orderId, Action action, BigDecimal amount) {

    public enum Action {
        START,
        ABORT;
    }

    @JsonCreator
    public PaymentEvent(@JsonProperty("orderId") final UUID orderId,
                        @JsonProperty("action") final Action action,
                        @JsonProperty("amount") BigDecimal amount) {
        this.orderId = orderId;
        this.action = action;
        this.amount = amount;
    }
}
