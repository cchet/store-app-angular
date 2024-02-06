package at.ihet.store.electronic.service.catalog.product.outbound.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
class ProductReservationId implements Serializable {

    @NotNull
    @Column(name = "reservation_id")
    private UUID reservationId;

    @NotEmpty
    @Column(name = "product_id")
    private String productId;

    /**
     * For JPA only
     */
    public ProductReservationId() {
    }

    private ProductReservationId(UUID reservationId, String productId) {
        this.reservationId = reservationId;
        this.productId = productId;
    }

    public static ProductReservationId of(UUID reservationId, String productId) {
        return new ProductReservationId(reservationId, productId);
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductReservationId that = (ProductReservationId) o;
        return Objects.equals(reservationId, that.reservationId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, productId);
    }
}
