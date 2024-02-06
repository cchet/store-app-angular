package at.ihet.store.electronic.service.catalog.product.domain;

import java.math.BigDecimal;
import java.util.*;

public class Product {

    private final String id;

    private String name;

    private BigDecimal price;

    private BigDecimal taxPercent;

    private ProductType type;
    private int count;

    private List<ProductReservation> reservations;

    public Product(final Builder builder) {
        this.id = Objects.requireNonNull(builder.id);
        this.name = Objects.requireNonNull(builder.name);
        this.price = Objects.requireNonNull(builder.price);
        this.taxPercent = Objects.requireNonNull(builder.taxPercent);
        this.count = builder.count;
        this.type = builder.type;
        this.reservations = Optional.ofNullable(builder.reservation).orElseGet(ArrayList::new);
        validate();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void addReservation(final UUID id, final int count) {
        var existingReservation = findById(Objects.requireNonNull(id));
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be greater than zero");
        }
        if (existingReservation.isPresent()) {
            throw new IllegalArgumentException("Reservation already exists for id: " + id);
        }
        if (this.countWithoutReservations() < count) {
            throw new IllegalArgumentException("Reservation count exceeds available product count");
        }
        reservations.add(new ProductReservation(id, count));
    }

    private Optional<ProductReservation> findById(final UUID id) {
        return (reservations.isEmpty()) ? Optional.empty() : reservations.stream().filter(reservation -> id.equals(reservation.getId())).findFirst();
    }
    private Integer countWithoutReservations() {
        return count - reservations.stream().map(ProductReservation::getCount).reduce(0, Integer::sum);
    }
    private void validate() {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (taxPercent.compareTo(BigDecimal.ZERO) <= 0 || taxPercent.compareTo(new BigDecimal("100.00")) > 0) {
            throw new IllegalArgumentException("TaxPercent must be between 0 and 100");
        }
        if (count < 0) {
            throw new IllegalArgumentException("Count must be greater or equal than zero");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public ProductType getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public List<ProductReservation> getReservations() {
        return reservations;
    }

    public static class Builder {
        private String id;
        private String name;
        private BigDecimal price;
        private BigDecimal taxPercent;
        private ProductType type;
        private int count;
        private List<ProductReservation> reservation;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setTaxPercent(BigDecimal taxPercent) {
            this.taxPercent = taxPercent;
            return this;
        }

        public Builder setType(ProductType type) {
            this.type = type;
            return this;
        }

        public Builder setCount(int count) {
            this.count = count;
            return this;
        }

        public Builder setReservation(List<ProductReservation> reservation) {
            this.reservation = reservation;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
