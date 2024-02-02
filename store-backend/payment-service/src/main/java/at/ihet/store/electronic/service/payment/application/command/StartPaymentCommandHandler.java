package at.ihet.store.electronic.service.payment.application.command;

import at.ihet.store.electronic.service.payment.domain.Payment;
import at.ihet.store.electronic.service.payment.domain.port.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Transactional
class StartPaymentCommandHandler implements StartPaymentCommand {

    private final PaymentRepository paymentRepository;

    @Autowired
    public StartPaymentCommandHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public UUID start(StartPaymentRequest request) {
        var payment = Payment.newPayment(request.orderId(), request.amount());
        return paymentRepository.create(payment);
    }
}
