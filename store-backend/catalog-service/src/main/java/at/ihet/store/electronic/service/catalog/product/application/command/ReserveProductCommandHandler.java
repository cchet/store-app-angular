package at.ihet.store.electronic.service.catalog.product.application.command;

import at.ihet.store.electronic.service.catalog.product.domain.port.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Transactional
class ReserveProductCommandHandler implements ReserveProductCommand {

    private final ProductRepository productRepository;

    @Autowired
    public ReserveProductCommandHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void reserve(ReserveProductRequest request) {
        for (var reservation : request.productIdCountMap().entrySet()) {
            var product = productRepository.findById(reservation.getKey()).orElseThrow(() -> new IllegalArgumentException("Cannot make reservation for non-existing product with id: " + reservation.getKey()));
            product.addReservation(request.id(), reservation.getValue());
            productRepository.save(product);
        }
    }
}
