package at.ihet.store.electronic.service.catalog.product.outbound.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "product_reservation")
class ProductReservationEntity {

    @NotNull
    @EmbeddedId
    public ProductReservationId id;

    @NotNull
    @Min(1)
    @Column(name = "count")
    public Integer count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ProductEntity product;

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductReservationEntity that = (ProductReservationEntity) o;
        return (id == null) ? super.equals(o) : Objects.equals(id, that.id) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return (id == null) ? super.hashCode() : Objects.hash(id, count);
    }
}
