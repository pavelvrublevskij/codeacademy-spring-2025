package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.core.helper.MessageService;
import lt.codeacademy.spring2025.eshop.product.exception.ProductNotFoundException;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static lt.codeacademy.spring2025.eshop.config.cache.CachingConstant.PRODUCTS_CACHE_NAME;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductRecipient {

  public static final String PRODUCT_NOT_FOUND_TRANSL_KEY = "product.exception.not.found";

  private final ProductRepository productRepository;
  private final ProductEntityMapper productEntityMapper;
  private final MessageService messageService;

  public Page<Product> getAllProductsPaginated(Pageable pageable) {
    return productRepository.findAll(pageable).map(productEntityMapper::toDomain);
  }

  @Cacheable(value = PRODUCTS_CACHE_NAME, key = "'allProducts'")
  public List<Product> getAllProducts() {
    log.info("===> Fetch all products from database");
    return productRepository.findAll().stream().map(productEntityMapper::toDomain).toList();
  }

  public Product getProductById(final UUID productId) {
    return productRepository.findByProductId(productId)
      .map(productEntityMapper::toDomain)
      .orElseThrow(() -> new ProductNotFoundException(messageService.getTranslatedMessage(PRODUCT_NOT_FOUND_TRANSL_KEY, productId)));
  }
}
