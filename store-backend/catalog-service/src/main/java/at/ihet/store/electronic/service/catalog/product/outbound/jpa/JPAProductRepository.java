package at.ihet.store.electronic.service.catalog.product.outbound.jpa;

import org.springframework.data.repository.CrudRepository;

public interface JPAProductRepository extends CrudRepository<ProductEntity, String> {
}
