package at.ihet.store.electronic.service.order.domain;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItem {

    @NotEmpty
    private String productId;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer count;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("1000000.00")
    private BigDecimal price;

    private OrderItem(String productId, Integer count, BigDecimal price) {
        this.productId = productId;
        this.count = count;
        this.price = price;
    }

    public static OrderItem create(final String productId, final int count, final BigDecimal price) {
        return new OrderItem(productId, count, price);
    }

    public void increaseCount() {
        count++;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(productId, orderItem.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
