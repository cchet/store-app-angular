package at.ihet.store.electronic.service.catalog.product.outbound.jpa;

import at.ihet.store.electronic.service.catalog.product.application.query.ProductDto;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class ProductDtoMapper {

    public List<ProductDto> toDtos(final Iterable<ProductEntity> entities) {
        return StreamSupport.stream(entities.spliterator(), false).map(this::toDto).collect(Collectors.toList());
    }

    public ProductDto toDto(final ProductEntity entity) {
        return new ProductDto(entity.id, entity.name, entity.type, entity.count, entity.price, entity.taxPercent);
    }
}
