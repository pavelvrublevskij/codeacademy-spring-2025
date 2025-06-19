package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import java.util.UUID;

import lt.codeacademy.spring2025.eshop.core.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

  void save(final Product product);

  void update(final Product product);

  Page<Product> getAllProductsPaginated(Pageable pageable);

  List<Product> getAllProducts();

  Product getProductById(final UUID productId);

  void deleteProductByUUID(final UUID productId);
}
