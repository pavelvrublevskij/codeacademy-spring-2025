package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {

	private final ProductRepository productRepository;

	public void save(final Product product) {
//    log.atInfo().log("=== Saving product ===");  // not recommended to use mostly in project because of performance issue
		productRepository.save(product);
	}

  public void update(final Product product) {
    productRepository.update(product);
  }

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

  public Product getProductById(final long productId) {
    return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
  }
}
