package at.ihet.store.electronic.service.order.outbound.amqp;

import at.ihet.store.electronic.service.order.domain.event.OrderCreatedEvent;
import at.ihet.store.electronic.service.order.domain.port.OrderEventPublisher;
import at.ihet.store.electronic.service.order.shared.ApplicationConfiguration;
import org.slf4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class AmqpEventPublisher implements OrderEventPublisher {

    private final ApplicationConfiguration applicationConfiguration;
    private final Logger log;
    private final AmqpTemplate amqpTemplate;

    @Autowired
    AmqpEventPublisher(ApplicationConfiguration applicationConfiguration, Logger log, AmqpTemplate amqpTemplate) {
        this.applicationConfiguration = applicationConfiguration;
        this.log = log;
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void publishOrderCreated(OrderCreatedEvent event) {
        amqpTemplate.convertAndSend(applicationConfiguration.queueNameInbound, event.orderId.toString());
        log.info("Published orderId to queue " + applicationConfiguration.queueNameInbound);
    }
}
