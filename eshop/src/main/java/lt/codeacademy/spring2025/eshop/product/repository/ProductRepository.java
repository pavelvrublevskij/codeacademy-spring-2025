package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

  Optional<ProductEntity> findByProductId(UUID productId);

  void deleteByProductId(UUID productId);
}
