package at.ihet.store.electronic.service.payment.domain.port;

import at.ihet.store.electronic.service.payment.domain.Payment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface PaymentRepository {

    UUID create(Payment payment);

    void update(Payment payment);

    List<Payment> overduePayments(int maxOverdueSeconds);
}
