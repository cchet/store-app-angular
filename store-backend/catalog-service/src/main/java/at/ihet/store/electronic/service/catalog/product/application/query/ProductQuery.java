package at.ihet.store.electronic.service.catalog.product.application.query;

import java.util.List;
import java.util.Optional;

public interface ProductQuery {

    List<ProductDto> listAll();

    Optional<ProductDto> findById(String id);
}
