package at.ihet.store.electronic.service.catalog.product.inbound.amqp;

import at.ihet.store.electronic.service.catalog.product.application.command.ReserveProductCommand;
import at.ihet.store.electronic.service.catalog.product.application.command.ReserveProductRequest;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@RabbitListener(queues = "${catalog.queue.catalog}")
class CatalogQueueListener {

    private final ReserveProductCommand reserveProductCommand;
    private final Logger log;

    @Autowired
    CatalogQueueListener(ReserveProductCommand reserveProductCommand, Logger log) {
        this.reserveProductCommand = reserveProductCommand;
        this.log = log;
    }

    @RabbitHandler
    void reserveProducts(@Payload CatalogReserveMessage message) {
        try {
            var reserveProductRequest = new ReserveProductRequest(message.id(), message.productIdCountMap());
            reserveProductCommand.reserve(reserveProductRequest);
            // Notify about successful reservation
        } catch (Exception e) {
            // Notify about failed reservation
            e.printStackTrace();
        }
        log.info("Reserving products message received: " + message);
    }

    @RabbitHandler
    void bookOut(@Payload CatalogBookOutMessage message) {
        log.info("Book out products message received: " + message);
    }
}
