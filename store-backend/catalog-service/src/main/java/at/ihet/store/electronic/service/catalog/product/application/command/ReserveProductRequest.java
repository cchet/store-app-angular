package at.ihet.store.electronic.service.catalog.product.application.command;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public record ReserveProductRequest(UUID id, Map<String, Integer> productIdCountMap) {

    public ReserveProductRequest(UUID id, Map<String, Integer> productIdCountMap) {
        this.id = Objects.requireNonNull(id);
        this.productIdCountMap = Objects.requireNonNull(productIdCountMap);
    }
}
