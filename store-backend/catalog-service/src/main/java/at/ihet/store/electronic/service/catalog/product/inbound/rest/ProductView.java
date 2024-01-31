package at.ihet.store.electronic.service.catalog.product.inbound.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductView(@JsonProperty("id") String id,
                          @JsonProperty("name") String name,
                          @JsonProperty("type") ProductTypeView type,
                          @JsonProperty("count") Integer count,
                          @JsonProperty("price") BigDecimal price,
                          @JsonProperty("taxPercent") BigDecimal tax) {
}
