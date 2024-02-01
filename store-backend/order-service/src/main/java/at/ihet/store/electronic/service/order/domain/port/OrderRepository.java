package at.ihet.store.electronic.service.order.domain.port;

import at.ihet.store.electronic.service.order.domain.Order;

import java.util.UUID;

public interface OrderRepository {

    UUID create(Order order);
}
