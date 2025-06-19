package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import lt.codeacademy.spring2025.eshop.product.model.ProductCategoryEntity;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Integer> {
  Optional<ProductCategoryEntity> findByName(String name);
}
