package at.ihet.store.electronic.service.order.application.command;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

public record CreateOrderRequest(@NotEmpty List<Item> items) {

    public static record Item(String productId, int count) {
    }

    public CreateOrderRequest(List<Item> items) {
        this.items = Objects.requireNonNull(items, "Items must not be null");
    }

    public static CreateOrderRequest of(List<Item> items) {
        return new CreateOrderRequest(items);
    }
}
