package at.ihet.store.electronic.service.payment.outbound.jpa;

import at.ihet.store.electronic.service.payment.domain.PaymentMethod;
import at.ihet.store.electronic.service.payment.domain.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment")
class PaymentEntity {

    @Id
    @NotNull
    public UUID id;

    @Column(name = "order_id", updatable = false)
    @NotNull
    public UUID orderId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NotNull
    public PaymentStatus status;

    @Column(name = "method")
    @Enumerated(EnumType.STRING)
    public PaymentMethod method;

    @Column(name = "amount")
    @DecimalMin("0.01")
    public BigDecimal amount;


    @Column(name = "finished_date")
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime finishedDate;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime creationDate;

    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime modificationDate;

    @PreUpdate
    void onUpdate() {
        modificationDate = LocalDateTime.now();
    }

    @PrePersist
    void onPersist() {
        creationDate = modificationDate = LocalDateTime.now();
    }
}
