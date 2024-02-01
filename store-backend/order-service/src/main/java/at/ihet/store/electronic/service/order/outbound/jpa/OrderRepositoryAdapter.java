package at.ihet.store.electronic.service.order.outbound.jpa;

import at.ihet.store.electronic.service.order.domain.Order;
import at.ihet.store.electronic.service.order.domain.port.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class OrderRepositoryAdapter implements OrderRepository {

    private final JPAOrderRepository jpaOrderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderRepositoryAdapter(JPAOrderRepository jpaOrderRepository, OrderMapper orderMapper) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public UUID create(Order order) {
        var orderEntity = orderMapper.toOrderEntity(order);
        jpaOrderRepository.save(orderEntity);
        return orderEntity.id;
    }
}
