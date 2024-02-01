package at.ihet.store.electronic.service.order.outbound.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class OrderEvent {

    public static enum State {
        CREATED
    }

    @JsonProperty("orderId")
    public UUID orderId;

    @JsonProperty("state")
    public State state;

    public static OrderEvent orderEventCreated(final UUID orderId) {
        var event = new OrderEvent();
        event.state = State.CREATED;
        event.orderId = orderId;

        return event;
    }
}
