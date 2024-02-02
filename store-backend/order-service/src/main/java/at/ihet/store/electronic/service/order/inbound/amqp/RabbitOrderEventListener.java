package at.ihet.store.electronic.service.order.inbound.amqp;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RabbitOrderEventListener {

    private final Logger log;

    @Autowired
    public RabbitOrderEventListener(Logger log) {
        this.log = log;
    }

    @RabbitListener(queues = "${order.queue.order}")
    void receiveOrderEvent(final OrderEvent event) {
        log.info(event.toString());
    }
}
