package at.ihet.store.electronic.service.order.outbound.jpa;

import at.ihet.store.electronic.service.order.domain.OrderState;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @NotNull
    public UUID id;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime creationDate;

    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime modificationDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    public OrderState state;

    @ElementCollection(fetch = FetchType.EAGER)
    @Valid
    @Size(min = 1, max = 10)
    public List<OrderItemEntity> items;

    @PreUpdate
    void onUpdate() {
        modificationDate = LocalDateTime.now();
    }

    @PrePersist
    void onPersist() {
        creationDate = modificationDate = LocalDateTime.now();
    }
}
