package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public void save(final Product product) {
		productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
