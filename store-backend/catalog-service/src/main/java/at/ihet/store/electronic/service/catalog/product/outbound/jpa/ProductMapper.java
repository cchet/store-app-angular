package at.ihet.store.electronic.service.catalog.product.outbound.jpa;


import at.ihet.store.electronic.service.catalog.product.domain.Product;
import at.ihet.store.electronic.service.catalog.product.domain.ProductReservation;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class ProductMapper {

    public Product toProduct(final ProductEntity entity) {
        return Product.newBuilder()
                .setId(entity.id)
                .setName(entity.name)
                .setPrice(entity.price)
                .setTaxPercent(entity.taxPercent)
                .setCount(entity.count)
                .setType(entity.type)
                .setReservation(entity.reservations.stream().map(this::toProductReservation).collect(Collectors.toList()))
                .build();
    }

    public ProductReservation toProductReservation(final ProductReservationEntity entity) {
        return new ProductReservation(entity.id.getReservationId(), entity.getCount());
    }

    public ProductEntity toProductEntity(final Product product) {
        var entity = new ProductEntity();
        entity.id = product.getId();
        entity.name = product.getName();
        entity.price = product.getPrice();
        entity.taxPercent = product.getTaxPercent();
        entity.count = product.getCount();
        entity.type = product.getType();
        entity.reservations.addAll(product.getReservations().stream().map(reservation -> toProductReservationEntity(product, reservation)).toList());

        return entity;
    }

    public List<ProductReservationEntity> toProductReservationEntities(final Product product, final List<ProductReservation> productReservations){
        return productReservations.stream().map(reservation -> toProductReservationEntity(product, reservation)).collect(Collectors.toList());
    }

    public ProductReservationEntity toProductReservationEntity(final Product product, final ProductReservation productReservation) {
        var entity = new ProductReservationEntity();
        entity.id = ProductReservationId.of(productReservation.getId(), product.getId());
        entity.count = productReservation.getCount();

        return entity;
    }
}
