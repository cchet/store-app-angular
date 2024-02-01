package at.ihet.store.electronic.service.order.outbound.jpa;

import at.ihet.store.electronic.service.order.domain.Order;
import at.ihet.store.electronic.service.order.domain.OrderItem;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OrderMapper {

    public OrderEntity toOrderEntity(final Order order) {
        var entity = new OrderEntity();
        entity.id = order.getId();
        entity.state = order.getState();
        entity.items = toOrderItemEntities(order.getItems());

        return entity;
    }

    private List<OrderItemEntity> toOrderItemEntities(final List<OrderItem> orderItems) {
        return orderItems.stream().map(this::toOrderItemEntity).collect(Collectors.toList());
    }

    private OrderItemEntity toOrderItemEntity(final OrderItem orderItem) {
        var entity = new OrderItemEntity();
        entity.productId = orderItem.getProductId();
        entity.count = orderItem.getCount();
        entity.price = orderItem.getPrice();

        return entity;
    }
}
