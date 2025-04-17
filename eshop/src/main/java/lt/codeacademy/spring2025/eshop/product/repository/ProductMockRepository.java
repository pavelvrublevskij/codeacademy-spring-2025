package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.*;

import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;

@Repository
@RequiredArgsConstructor
public class ProductMockRepository implements ProductRepository {

	private final ProductEntityMapper productEntityMapper;

	private final Map<UUID, ProductEntity> productEntities = new HashMap<>();

	public void save(final Product product) {
		final UUID productUUID = UUID.randomUUID();
		product.setId(productUUID);
		productEntities.put(productUUID, productEntityMapper.toProductEntity(product));
	}

	public List<Product> findAll() {
		return productEntities.values().stream().map(productEntityMapper::toProduct).toList();
	}

	public void update(final Product product) {
		productEntities.put(product.getId(), productEntityMapper.toProductEntity(product));
	}

	public Optional<Product> findById(final UUID productId) {
		return Optional.ofNullable(productEntities.get(productId))
				.map(productEntityMapper::toProduct);
	}

	public void deleteProductByUUID(final UUID productId) {
		productEntities.remove(productId);
	}
}
