package at.ihet.store.electronic.service.payment.inbound.amqp;

import at.ihet.store.electronic.service.payment.application.command.StartPaymentCommand;
import at.ihet.store.electronic.service.payment.application.command.StartPaymentRequest;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class AmqpOrderListener {

    private final StartPaymentCommand startPaymentCommand;
    private final Logger log;

    @Autowired
    public AmqpOrderListener(StartPaymentCommand startPaymentCommand, Logger log) {
        this.startPaymentCommand = startPaymentCommand;
        this.log = log;
    }

    @RabbitListener(queues = "${payment.queue.payment}")
    void receivePaymentEvent(PaymentEvent event) {
        log.info(event.toString());
        startPaymentCommand.start(new StartPaymentRequest(event.orderId(), event.amount()));
    }
}
