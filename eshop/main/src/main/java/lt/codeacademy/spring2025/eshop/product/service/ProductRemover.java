package lt.codeacademy.spring2025.eshop.product.service;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductRemover {

  private final ProductRepository productRepository;

  @Transactional
  public void deleteProductByUUID(final UUID productId) {
    productRepository.deleteByProductId(productId);
  }

}
