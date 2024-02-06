package at.ihet.store.electronic.service.catalog.product.inbound.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;

import java.util.Map;
import java.util.UUID;

public record CatalogReserveMessage(@JsonProperty("id") UUID id,
                                    @JsonProperty("productIdCountMap")
                                    @JsonSerialize(keyUsing = MapSerializer.class) Map<String, Integer> productIdCountMap) {
}
