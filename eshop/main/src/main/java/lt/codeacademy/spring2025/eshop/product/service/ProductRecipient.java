package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.core.helper.MessageService;
import lt.codeacademy.spring2025.eshop.product.exception.ProductNotFoundException;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

  public List<Product> getAllProducts() {
    return productRepository.findAll().stream().map(productEntityMapper::toDomain).toList();
  }

  public Product getProductById(final UUID productId) {
    return productRepository.findByProductId(productId)
      .map(productEntityMapper::toDomain)
      .orElseThrow(() -> new ProductNotFoundException(messageService.getTranslatedMessage(PRODUCT_NOT_FOUND_TRANSL_KEY, productId)));
  }
}
