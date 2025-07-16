package lt.codeacademy.spring2025.eshop.product.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductUpdater {

  private final ProductRepository productRepository;

  @Transactional
  public void update(final Product product) {
    productRepository.findByProductId(product.getId())
      .ifPresent(entity -> {
        entity.setAmountInStock(product.getAmount());
        entity.setPrice(product.getPrice());
        entity.setDescription(product.getDescription());
        entity.setName(product.getName());
        productRepository.save(entity);
      });
  }
}
