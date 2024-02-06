package at.ihet.store.electronic.service.catalog.product.outbound.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

interface JPAProductRepository extends CrudRepository<ProductEntity, String> {

    @Query(name = "product.finByIdWithReservations")
    Optional<ProductEntity> findByIdWithReservations(@Param("id") String id);
}
