package at.ihet.store.electronic.service.payment.application.command;

import at.ihet.store.electronic.service.payment.domain.port.PaymentRepository;
import at.ihet.store.electronic.service.payment.shared.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Transactional
class AbortOverduePaymentsCommandHandler implements AbortOverduePaymentsCommand {

    private final ApplicationConfiguration applicationConfiguration;
    private final PaymentRepository paymentRepository;

    @Autowired
    public AbortOverduePaymentsCommandHandler(ApplicationConfiguration applicationConfiguration, PaymentRepository paymentRepository) {
        this.applicationConfiguration = applicationConfiguration;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void abort() {
        var overduePayments = paymentRepository.overduePayments(applicationConfiguration.maxPendingPaymentSeconds);
        overduePayments.forEach(payment -> {
            payment.abortOverdue();
            paymentRepository.update(payment);
        });
    }
}
