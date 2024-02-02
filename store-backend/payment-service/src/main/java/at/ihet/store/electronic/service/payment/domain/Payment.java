package at.ihet.store.electronic.service.payment.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Payment {

    private final UUID id;

    private final UUID orderId;

    private PaymentStatus status;

    private PaymentMethod method;

    private BigDecimal amount;

    private LocalDateTime finishedDate;

    Payment(Builder builder) {
        this.id = Objects.requireNonNull(builder.id);
        this.orderId = Objects.requireNonNull(builder.orderId);
        this.status = Objects.requireNonNull(builder.status);
        this.method = builder.method;
        this.amount = Objects.requireNonNull(builder.amount);
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }

    public static Payment.Builder newBuilder() {
        return new Builder();
    }

    public static Payment newPayment(final UUID orderId, final BigDecimal amount) {
        return newBuilder().setId(UUID.randomUUID())
                .setOrderId(orderId)
                .setStatus(PaymentStatus.PENDING)
                .setAmount(amount)
                .build();
    }

    public void abortOverdue() {
        if (!PaymentStatus.ABORTED_OVERDUE.equals(status)) {
            status = PaymentStatus.ABORTED_OVERDUE;
            finishedDate = LocalDateTime.now();
        }
    }

    public UUID getId() {
        return id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getFinishedDate() {
        return finishedDate;
    }

    public static class Builder {
        private UUID id;
        private UUID orderId;
        private PaymentStatus status;
        private PaymentMethod method;
        private BigDecimal amount;

        private LocalDateTime finishedDate;

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setOrderId(UUID orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setStatus(PaymentStatus status) {
            this.status = status;
            return this;
        }

        public Builder setMethod(PaymentMethod method) {
            this.method = method;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder setFinishedDate(LocalDateTime finishedDate) {
            this.finishedDate = finishedDate;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
