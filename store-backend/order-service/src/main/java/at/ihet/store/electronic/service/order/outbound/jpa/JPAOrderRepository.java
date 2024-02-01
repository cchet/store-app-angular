package at.ihet.store.electronic.service.order.outbound.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface JPAOrderRepository extends CrudRepository<OrderEntity, UUID> {
}
