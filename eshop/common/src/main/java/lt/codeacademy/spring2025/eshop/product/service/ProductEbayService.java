package lt.codeacademy.spring2025.eshop.product.service;

import java.util.Collections;
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

@Profile("ebay")
@Service
@Log4j2
@RequiredArgsConstructor
public class ProductEbayService implements ProductService {

  private final ProductSaver productSaver;
  private final ProductUpdater productUpdater;
  private final ProductRecipient productRecipient;
  private final ProductRecipientCachable productRecipientCachable;

  @Transactional
  public void save(final Product product) {
    productSaver.save(product);
  }

  @Transactional
  public void update(final Product product) {
    productUpdater.update(product);
  }

  public Page<Product> getAllProductsPaginated(Pageable pageable) {
    return Page.empty();
  }

  public List<Product> getAllProducts() {
    return Collections.emptyList();
  }

  public Product getProductById(final UUID productId) {
    return productRecipientCachable.getProductById(productId);
  }

  @Transactional
  public void deleteProductByUUID(final UUID productId) {
    throw new RuntimeException("For ebay delete product not possible!");
  }

  @Override
  public Product getProductByIdForUpdate(UUID productId) {
    return productRecipient.getProductById(productId);
  }
}
