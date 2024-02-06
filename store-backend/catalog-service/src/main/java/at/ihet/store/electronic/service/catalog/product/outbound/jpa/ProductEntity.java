package at.ihet.store.electronic.service.catalog.product.outbound.jpa;

import at.ihet.store.electronic.service.catalog.product.domain.ProductType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "product.listAll", query = "select product from ProductEntity product left outer join fetch product.reservations"),
        @NamedQuery(name = "product.finByIdWithReservations", query = "select distinct product from ProductEntity product left outer join fetch product.reservations where product.id = :id")
})
class ProductEntity {

    @Id
    @Column(name = "id")
    @NotEmpty
    public String id;

    @Column(name = "name")
    @NotEmpty
    @Size(min = 1, max = 100)
    public String name;

    @Column(name = "count")
    @Min(0)
    public int count;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    public ProductType type;

    @Column(name = "price")
    @NotNull
    @DecimalMin("0.00")
    public BigDecimal price;

    @Column(name = "tax_percent")
    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("100.00")
    public BigDecimal taxPercent;

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime creationDate;

    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime modificationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = {
            CascadeType.ALL
    })
    public List<ProductReservationEntity> reservations = new ArrayList<>(0);

    @PreUpdate
    void onUpdate() {
        modificationDate = LocalDateTime.now();
    }

    @PrePersist
    void onPersist() {
        creationDate = modificationDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
