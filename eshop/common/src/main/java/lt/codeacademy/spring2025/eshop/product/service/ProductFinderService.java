package lt.codeacademy.spring2025.eshop.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductFinderService {

  private final ProductRepository productRepository;
  private final ProductEntityMapper productEntityMapper;

  public Page<Product> findProductsByNamePageable(final String productName, Pageable pageable) {
    return productRepository.findByNameIsLikeIgnoreCase(convertToLikeRegex(productName), pageable)
      .map(productEntityMapper::toDomain);
  }

  private String convertToLikeRegex(String productName) {
    return "%" + productName + "%";
  }
}
