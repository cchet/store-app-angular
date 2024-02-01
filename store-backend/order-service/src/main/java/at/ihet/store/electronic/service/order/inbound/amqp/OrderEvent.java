package at.ihet.store.electronic.service.order.inbound.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class OrderEvent {

    public static enum State {
        SUCCESS,
        ERROR,
        ABORTED
    }

    @JsonProperty("orderId")
    public UUID orderId;

    @JsonProperty("state")
    public State state;
}
