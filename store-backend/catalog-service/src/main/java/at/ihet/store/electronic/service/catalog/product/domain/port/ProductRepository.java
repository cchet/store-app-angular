package at.ihet.store.electronic.service.catalog.product.domain.port;

import at.ihet.store.electronic.service.catalog.product.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(String id);

    String save(Product product);
}
