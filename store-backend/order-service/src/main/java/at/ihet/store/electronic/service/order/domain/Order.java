package at.ihet.store.electronic.service.order.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.*;

public class Order {

    @NotNull
    private final UUID id;

    @NotNull
    private final OrderState state;

    @Valid
    private final List<OrderItem> items = new LinkedList<>();

    private Order(final UUID id, final OrderState state) {
        this.id = id;
        this.state = state;
    }

    public static Order newOrder() {
        return new Order(UUID.randomUUID(), OrderState.PENDING);
    }

    public void addOrderItem(final OrderItem orderItem) {
        Objects.requireNonNull(orderItem, "OrderItem must not be null");
        orderItemForProductId(orderItem.getProductId()).ifPresentOrElse(OrderItem::increaseCount, () -> items.add(orderItem));
    }

    private Optional<OrderItem> orderItemForProductId(final String productId) {
        return items.stream()
                .filter(item -> item.getProductId().equals(productId))
                .findAny();
    }

    public UUID getId() {
        return id;
    }

    public OrderState getState() {
        return state;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
