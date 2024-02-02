package at.ihet.store.electronic.service.payment.outbound.jpa;

import at.ihet.store.electronic.service.payment.domain.Payment;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class PaymentEntityMapper {

    public List<Payment> toPayments(final List<PaymentEntity> entities) {
        return entities.stream().map(this::toPayment).collect(Collectors.toList());
    }

    public Payment toPayment(final PaymentEntity entity) {
        return Payment.newBuilder()
                .setId(entity.id)
                .setOrderId(entity.orderId)
                .setStatus(entity.status)
                .setMethod(entity.method)
                .setAmount(entity.amount)
                .setFinishedDate(entity.finishedDate)
                .build();
    }

    public PaymentEntity toPaymentEntity(final Payment payment) {
        var entity = new PaymentEntity();
        entity.id = payment.getId();
        entity.orderId = payment.getOrderId();
        entity.status = payment.getStatus();
        entity.method = payment.getMethod();
        entity.amount = payment.getAmount();
        entity.finishedDate = payment.getFinishedDate();

        return entity;
    }
}
