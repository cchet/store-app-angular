package at.ihet.store.electronic.service.order.outbound.jpa;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Embeddable
public class OrderItemEntity {

    @NotNull
    public String productId;

    @NotNull
    @Min(1)
    @Max(10)
    public Integer count;

    @NotNull
    @DecimalMin("0.01")
    @DecimalMax("1000000.00")
    public BigDecimal price;
}
