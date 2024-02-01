package at.ihet.store.electronic.service.order.inbound.rest;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderItemView(@JsonProperty("productId") String productId,
                            @JsonProperty("count") int count,
                            @JsonProperty("price") BigDecimal price) {
}
