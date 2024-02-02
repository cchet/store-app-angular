package at.ihet.store.electronic.service.catalog.product.domain.port;

import at.ihet.store.electronic.service.catalog.product.application.query.ProductDto;

import java.util.List;

public interface ProductReadRepository {

    List<ProductDto> list();

    ProductDto byId(String id);

    List<ProductDto> byIds(List<String> id);
}
