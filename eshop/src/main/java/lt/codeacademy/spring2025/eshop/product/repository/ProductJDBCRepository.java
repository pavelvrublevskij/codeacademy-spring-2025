package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import lt.codeacademy.spring2025.eshop.core.domain.Product;

@Repository
public class ProductJDBCRepository implements ProductRepository {
  @Override
  public void save(Product product) {

  }

  @Override
  public List<Product> findAll() {
    return List.of();
  }

  @Override
  public void update(Product product) {

  }

  @Override
  public Optional<Product> findById(UUID productId) {
    return Optional.empty();
  }

  @Override
  public void deleteProductByUUID(UUID productId) {

  }
}
