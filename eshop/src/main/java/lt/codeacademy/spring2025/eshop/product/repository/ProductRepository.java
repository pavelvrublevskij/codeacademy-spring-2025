package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;

@Repository
public class ProductRepository {

	private final List<ProductDto> products = new ArrayList<>();

	public void save(final ProductDto productDto) {
		products.add(productDto);
	}

	public List<ProductDto> findAll() {
		return products;
	}
}
