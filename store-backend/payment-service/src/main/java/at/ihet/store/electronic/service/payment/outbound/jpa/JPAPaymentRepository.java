package at.ihet.store.electronic.service.payment.outbound.jpa;

import at.ihet.store.electronic.service.payment.domain.PaymentStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

interface JPAPaymentRepository extends CrudRepository<PaymentEntity, UUID> {

    @Query("select payment from PaymentEntity payment where payment.status = :status")
    List<PaymentEntity> findPaymentsByStatus(@Param("status") PaymentStatus status);
}
