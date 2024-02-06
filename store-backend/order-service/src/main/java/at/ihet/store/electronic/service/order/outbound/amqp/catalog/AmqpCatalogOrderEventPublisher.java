package at.ihet.store.electronic.service.order.outbound.amqp.catalog;

import at.ihet.store.electronic.service.order.domain.OrderItem;
import at.ihet.store.electronic.service.order.domain.event.OrderCreatedEvent;
import at.ihet.store.electronic.service.order.domain.port.OrderEventPublisher;
import at.ihet.store.electronic.service.order.shared.ApplicationConfiguration;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AmqpCatalogOrderEventPublisher implements OrderEventPublisher {

    private final ApplicationConfiguration applicationConfiguration;
    private final Logger log;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpCatalogOrderEventPublisher(ApplicationConfiguration applicationConfiguration, Logger log, RabbitTemplate rabbitTemplate) {
        this.applicationConfiguration = applicationConfiguration;
        this.log = log;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishOrderCreated(final OrderCreatedEvent event) {
        var productIdCountMap = event.order().getItems().stream().collect(Collectors.toMap(OrderItem::getProductId, OrderItem::getCount));
        var catalogReserveEvent = new CatalogReserveMessage(event.order().getId(), productIdCountMap);
        rabbitTemplate.convertAndSend(applicationConfiguration.queueNameCatalog, catalogReserveEvent);
        log.info("Catalog notified to reserve products for order: " + event.order().getId());
    }
}