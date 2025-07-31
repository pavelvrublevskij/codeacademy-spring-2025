package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.spring2025.core.domain.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Profile("amazon")
@Service
@Log4j2
@RequiredArgsConstructor
public class ProductAmazonService implements ProductService {

  private final ProductSaver productSaver;
  private final ProductUpdater productUpdater;
  private final ProductRecipient productRecipient;
  private final ProductRecipientCachable productRecipientCachable;
  private final ProductRemover productRemover;

  @Transactional
  public void save(final Product product) {
    productSaver.save(product);
  }

  @Transactional
  public void update(final Product product) {
    productUpdater.update(product);
  }

  public Page<Product> getAllProductsPaginated(Pageable pageable) {
    return productRecipientCachable.getAllProductsPaginated(pageable);
  }

  public List<Product> getAllProducts() {
    return productRecipientCachable.getAllProducts();
  }

  public Product getProductById(final UUID productId) {
    return productRecipientCachable.getProductById(productId);
  }

  @Transactional
  public void deleteProductByUUID(final UUID productId) {
    productRemover.deleteProductByUUID(productId);
  }

  @Override
  public Product getProductByIdForUpdate(UUID productId) {
    return productRecipient.getProductById(productId);
  }
}
