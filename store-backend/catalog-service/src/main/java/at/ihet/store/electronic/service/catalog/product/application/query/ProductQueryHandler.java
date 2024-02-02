package at.ihet.store.electronic.service.catalog.product.application.query;

import at.ihet.store.electronic.service.catalog.product.domain.port.ProductReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Transactional(readOnly = true)
class ProductQueryHandler implements ProductQuery {

    private final ProductReadRepository readRepository;

    @Autowired
    public ProductQueryHandler(ProductReadRepository readRepository) {
        this.readRepository = readRepository;
    }

    @Override
    public List<ProductDto> listAll() {
        return readRepository.list();
    }

    @Override
    public Optional<ProductDto> findById(String id) {
        var product = readRepository.byId(id);
        return Optional.ofNullable(product);
    }
    @Override
    public List<ProductDto> findByIds(List<String> ids) {
        return readRepository.byIds(ids);
    }
}
