package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

	private final ProductEntityMapper productEntityMapper;

	private final List<ProductEntity> productEntities = new ArrayList<>();

	public void save(final Product product) {
		productEntities.add(productEntityMapper.toProductEntity(product));
	}

	public List<Product> findAll() {
		return productEntities.stream().map(productEntityMapper::toProduct).toList();
	}

  public void update(final Product product) {
    productEntities.stream()
      .filter(productEntity -> productEntity.getId() == product.getId())
      .findFirst()
      .ifPresent(productEntity -> {
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setDescription(product.getDescription());
        productEntity.setAmountInStock(product.getAmount());
      });
  }

  public Optional<Product> findById(final long productId) {
    return productEntities.stream()
      .filter(productEntity -> productEntity.getId() == productId)
      .map(productEntityMapper::toProduct)
      .findFirst();
  }
}
