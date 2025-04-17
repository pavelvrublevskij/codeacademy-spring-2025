package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lt.codeacademy.spring2025.eshop.core.domain.Product;

public interface ProductRepository {

    void save(final Product product);

    List<Product> findAll();

    void update(final Product product);

    Optional<Product> findById(final UUID productId);

    void deleteProductByUUID(final UUID productId);
}
