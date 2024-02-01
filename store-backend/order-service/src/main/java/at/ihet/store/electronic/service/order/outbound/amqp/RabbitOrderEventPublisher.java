package at.ihet.store.electronic.service.order.outbound.amqp;

import at.ihet.store.electronic.service.order.domain.event.OrderCreatedEvent;
import at.ihet.store.electronic.service.order.domain.port.OrderEventPublisher;
import at.ihet.store.electronic.service.order.shared.ApplicationConfiguration;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class RabbitOrderEventPublisher implements OrderEventPublisher {

    private final ApplicationConfiguration applicationConfiguration;
    private final Logger log;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitOrderEventPublisher(ApplicationConfiguration applicationConfiguration, Logger log, RabbitTemplate rabbitTemplate) {
        this.applicationConfiguration = applicationConfiguration;
        this.log = log;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publishOrderCreated(OrderCreatedEvent event) {
        var rabbitOrderEvent = OrderEvent.orderEventCreated(event.orderId);
        rabbitTemplate.convertAndSend(applicationConfiguration.queueNameOutbound, rabbitOrderEvent);
        log.info("Published orderId to queue " + applicationConfiguration.queueNameOutbound);
    }
}