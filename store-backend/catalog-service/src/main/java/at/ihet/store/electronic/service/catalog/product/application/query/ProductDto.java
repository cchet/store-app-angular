package at.ihet.store.electronic.service.catalog.product.application.query;

import at.ihet.store.electronic.service.catalog.product.domain.ProductType;

import java.math.BigDecimal;

public record ProductDto(String id, String name, ProductType type, Integer count, BigDecimal price, BigDecimal tax) {
}
