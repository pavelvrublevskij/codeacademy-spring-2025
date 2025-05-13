package lt.codeacademy.spring2025.eshop.product.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductCategoryEntityMapper;
import lt.codeacademy.spring2025.eshop.product.repository.ProductCategoryRepository;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

  private final ProductCategoryRepository productCategoryRepository;
  private final ProductCategoryEntityMapper productCategoryEntityMapper;

  public Set<ProductCategory> getCategories() {
    return productCategoryRepository.findAll()
      .stream()
      .filter(productCategoryEntity -> !productCategoryEntity.getName().equals("NaN"))
      .map(productCategoryEntityMapper::toProductCategory)
      .collect(Collectors.toSet());
  }
}
