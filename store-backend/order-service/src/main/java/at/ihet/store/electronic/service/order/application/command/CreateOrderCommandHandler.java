package at.ihet.store.electronic.service.order.application.command;

import at.ihet.store.electronic.service.order.domain.Order;
import at.ihet.store.electronic.service.order.domain.OrderItem;
import at.ihet.store.electronic.service.order.domain.event.OrderCreatedEvent;
import at.ihet.store.electronic.service.order.domain.port.OrderRepository;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@Validated
@Transactional
class CreateOrderCommandHandler implements CreateOrderCommand {

    private final OrderRepository orderRepository;
    private final Validator validator;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public CreateOrderCommandHandler(OrderRepository orderRepository, Validator validator, ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.validator = validator;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public UUID create(@Valid CreateOrderRequest request) {
        var order = Order.newOrder();
        request.items().forEach(item -> order.addOrderItem(OrderItem.create(item.productId(), item.count(), BigDecimal.TEN)));
        validator.validate(order);
        eventPublisher.publishEvent(OrderCreatedEvent.of(order.getId(), order.amount()));

        return orderRepository.create(order);
    }
}
