package at.ihet.store.electronic.service.catalog.product.domain;

import java.util.Objects;
import java.util.UUID;

public class ProductReservation {

    private final UUID id;

    private final int count;

    public ProductReservation(UUID id, int count) {
        this.id = Objects.requireNonNull(id);
        this.count = count;
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be greater than zero");
        }
    }

    public UUID getId() {
        return id;
    }

    public int getCount() {
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
        ProductReservation that = (ProductReservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
