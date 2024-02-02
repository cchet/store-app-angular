package at.ihet.store.electronic.service.order.inbound.amqp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record OrderEvent(UUID orderId, Action action) {

    public enum Action {
        CLOSE,
        CLOSE_WITH_ERROR,
        ABORT
    }

    @JsonCreator
    public OrderEvent(@JsonProperty("orderId") UUID orderId, @JsonProperty("action") Action action) {
        this.orderId = orderId;
        this.action = action;
    }
}
