package at.ihet.store.electronic.service.catalog.product.inbound.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.UUID;

public record CatalogBookOutMessage(@JsonProperty("id") UUID id,
                                    @JsonProperty("productIdCountMap") Map<String, Integer> productIdCountMap) {
}
