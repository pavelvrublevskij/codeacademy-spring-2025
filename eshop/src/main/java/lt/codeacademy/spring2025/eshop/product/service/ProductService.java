package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.exception.ProductNotFoundException;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductEntityMapper productEntityMapper;

  public void save(final Product product) {
    productRepository.save(productEntityMapper.toProductEntity(product));
  }

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

  public Page<Product> getAllProductsPaginated(Pageable pageable) {
    return productRepository.findAll(pageable).map(productEntityMapper::toProduct);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll().stream().map(productEntityMapper::toProduct).toList();
  }

  public Product getProductById(final UUID productId) {
    return productRepository.findByProductId(productId)
      .map(productEntityMapper::toProduct)
      .orElseThrow(ProductNotFoundException::new);
  }

  @Transactional
  public void deleteProductByUUID(final UUID productId) {
    productRepository.deleteByProductId(productId);
  }
}
