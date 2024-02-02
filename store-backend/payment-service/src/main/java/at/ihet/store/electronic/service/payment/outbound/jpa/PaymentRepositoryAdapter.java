package at.ihet.store.electronic.service.payment.outbound.jpa;

import at.ihet.store.electronic.service.payment.domain.Payment;
import at.ihet.store.electronic.service.payment.domain.PaymentStatus;
import at.ihet.store.electronic.service.payment.domain.port.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class PaymentRepositoryAdapter implements PaymentRepository {

    private final JPAPaymentRepository jpaPaymentRepository;

    private final PaymentEntityMapper paymentEntityMapper;

    @Autowired
    public PaymentRepositoryAdapter(JPAPaymentRepository jpaPaymentRepository, PaymentEntityMapper paymentEntityMapper) {
        this.jpaPaymentRepository = jpaPaymentRepository;
        this.paymentEntityMapper = paymentEntityMapper;
    }

    @Override
    public UUID create(Payment payment) {
        var entity = paymentEntityMapper.toPaymentEntity(payment);
        return jpaPaymentRepository.save(entity).id;
    }

    @Override
    public void update(Payment payment) {
        var entity = paymentEntityMapper.toPaymentEntity(payment);
        jpaPaymentRepository.save(entity);
    }

    @Override
    public List<Payment> overduePayments(int maxOverdueSeconds) {
        var pendingPayments = jpaPaymentRepository.findPaymentsByStatus(PaymentStatus.PENDING);
        var now = LocalDateTime.now();
        var overduePayments = pendingPayments.stream().filter(payment -> now.isAfter(payment.creationDate.plusSeconds(maxOverdueSeconds))).collect(Collectors.toList());
        return paymentEntityMapper.toPayments(overduePayments);
    }
}
