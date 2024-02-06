package at.ihet.store.electronic.service.catalog.product.outbound.jpa;

import at.ihet.store.electronic.service.catalog.product.domain.Product;
import at.ihet.store.electronic.service.catalog.product.domain.port.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProductRepositoryAdapter implements ProductRepository {

    private final JPAProductRepository jpaProductRepository;
    private final ProductMapper productMapper;

    @Autowired
    ProductRepositoryAdapter(JPAProductRepository jpaProductRepository, ProductMapper productMapper) {
        this.jpaProductRepository = jpaProductRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<Product> findById(String id) {
        return jpaProductRepository.findByIdWithReservations(id).map(productMapper::toProduct);
    }

    @Override
    public String save(final Product product) {
        var entity = productMapper.toProductEntity(product);
        return jpaProductRepository.save(entity).id;
    }
}
