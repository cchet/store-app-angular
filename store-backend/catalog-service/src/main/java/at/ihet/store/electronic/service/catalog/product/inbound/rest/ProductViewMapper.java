package at.ihet.store.electronic.service.catalog.product.inbound.rest;

import at.ihet.store.electronic.service.catalog.product.application.query.ProductDto;
import at.ihet.store.electronic.service.catalog.product.domain.ProductType;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductViewMapper {

    public List<ProductView> toProductViews(final List<ProductDto> dtos) {
        return dtos.stream().map(this::toProductView).collect(Collectors.toList());
    }

    public ProductView toProductView(final ProductDto dto) {
        return new ProductView(dto.id(), dto.name(), toProductTypeView(dto.type()), dto.count(), dto.price(), dto.tax());
    }

    private static ProductTypeView toProductTypeView(ProductType type) {
        return ProductTypeView.toProductTypeView(type).orElseThrow(() -> new IllegalArgumentException("ProductTypeView has not mapping for ProductType: " + type.name()));
    }
}
