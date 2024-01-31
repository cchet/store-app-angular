package at.ihet.store.electronic.service.catalog.product.inbound.rest;

import at.ihet.store.electronic.service.catalog.product.domain.ProductType;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ProductTypeView {
    LAPTOP(ProductType.LAPTOP),
    ACCESSORIES(ProductType.ACCESSORIES),
    TABLET(ProductType.TABLET);

    public final ProductType type;

    private static final Map<ProductType, ProductTypeView> productTypeToProductTypeView = Stream.of(ProductTypeView.values()).collect(Collectors.toMap(ProductTypeView::getType, Function.identity()));
    private static final Map<ProductTypeView, ProductType> productTypeViewToProductType = Stream.of(ProductTypeView.values()).collect(Collectors.toMap(Function.identity(), ProductTypeView::getType));

    ProductTypeView(ProductType type) {
        this.type = type;
    }

    public static Optional<ProductTypeView> toProductTypeView(final ProductType type) {
        return Optional.ofNullable(productTypeToProductTypeView.get(type));
    }

    public static Optional<ProductType> toProductType(final ProductTypeView type) {
        return Optional.ofNullable(productTypeViewToProductType.get(type));
    }

    public ProductType getType() {
        return type;
    }
}
