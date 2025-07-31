package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.spring2025.core.domain.Product;

import static lt.codeacademy.spring2025.eshop.config.cache.CachingConstant.PRODUCTS_CACHE_NAME;
import static lt.codeacademy.spring2025.eshop.config.cache.CachingConstant.PRODUCTS_PAGINATED_CACHE_NAME;
import static lt.codeacademy.spring2025.eshop.config.cache.CachingConstant.PRODUCT_BY_UUID_CACHE_NAME;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductRecipientCachable {

  private final ProductRecipient productRecipient;

  @Cacheable(
    value = PRODUCTS_PAGINATED_CACHE_NAME,
    key = "#pageable.pageNumber + '_' + #pageable.pageSize + '_' + #pageable.sort.toString()",
    condition = "!@environment.acceptsProfiles('cache-redis')"
  )
  public Page<Product> getAllProductsPaginated(Pageable pageable) {
    return productRecipient.getAllProductsPaginated(pageable);
  }

  @Cacheable(value = PRODUCTS_CACHE_NAME, key = "'allProducts'")
  public List<Product> getAllProducts() {
    return productRecipient.getAllProducts();
  }

  @Cacheable(value = PRODUCT_BY_UUID_CACHE_NAME, key = "#productId")
  public Product getProductById(final UUID productId) {
    return productRecipient.getProductById(productId);
  }
}
