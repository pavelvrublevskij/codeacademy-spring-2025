package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;

@Repository
public class ProductRepository {

	private final List<ProductEntity> products = new ArrayList<>();

	public void save(final ProductEntity productDto) {
		products.add(productDto);
	}

	public List<ProductEntity> findAll() {
		return products;
	}
}
