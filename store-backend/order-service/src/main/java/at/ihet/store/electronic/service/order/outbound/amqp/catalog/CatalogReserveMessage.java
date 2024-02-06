package at.ihet.store.electronic.service.order.outbound.amqp.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.UUID;

public record CatalogReserveMessage(@JsonProperty("id") UUID id, @JsonProperty("productIdCountMap") Map<String, Integer> productIdCountMap) {

}
