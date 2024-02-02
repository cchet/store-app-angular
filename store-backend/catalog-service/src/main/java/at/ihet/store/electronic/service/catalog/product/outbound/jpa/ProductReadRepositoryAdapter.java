package at.ihet.store.electronic.service.catalog.product.outbound.jpa;

import at.ihet.store.electronic.service.catalog.product.application.query.ProductDto;
import at.ihet.store.electronic.service.catalog.product.domain.port.ProductReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class ProductReadRepositoryAdapter implements ProductReadRepository {

    private final JPAProductRepository jpaProductRepository;
    private final ProductDtoMapper productDtoMapper;

    @Autowired
    public ProductReadRepositoryAdapter(JPAProductRepository jpaProductRepository, ProductDtoMapper productDtoMapper) {
        this.jpaProductRepository = jpaProductRepository;
        this.productDtoMapper = productDtoMapper;
    }

    @Override
    public List<ProductDto> list() {
        var jpaProducts = jpaProductRepository.findAll();
        return productDtoMapper.toDtos(jpaProducts);
    }

    @Override
    public ProductDto byId(String id) {
        var jpaEntity = jpaProductRepository.findById(id).orElse(null);
        return (jpaEntity != null) ? productDtoMapper.toDto(jpaEntity) : null;
    }

    @Override
    public List<ProductDto> byIds(List<String> id) {
        var jpaEntities = jpaProductRepository.findAllById(id);
        return productDtoMapper.toDtos(jpaEntities);
    }
}
