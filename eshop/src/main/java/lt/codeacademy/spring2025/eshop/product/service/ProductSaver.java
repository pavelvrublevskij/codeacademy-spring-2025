package lt.codeacademy.spring2025.eshop.product.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.helper.MessageService;
import lt.codeacademy.spring2025.eshop.product.exception.ProductNotFoundException;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.model.ProductCategoryEntity;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;
import lt.codeacademy.spring2025.eshop.product.repository.ProductCategoryRepository;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductSaver {

  public static final String PRODUCT_CATEGORY_NOT_FOUND_TRANSL_KEY = "product.category.exception.not.found";

  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;
  private final ProductEntityMapper productEntityMapper;
  private final MessageService messageService;

  @Transactional
  public void save(final Product product) {
    final ProductCategoryEntity category = getFirstCategory(product);
    final ProductEntity productEntity = productEntityMapper.toEntity(product);
    productEntity.getProductCategories().add(category);

    productRepository.save(productEntity);
  }

  private ProductCategoryEntity getFirstCategory(final Product product) {
    final ProductCategory productCategory = product.getCategories().stream().findFirst()
      .orElseThrow(() -> new ProductNotFoundException(
        messageService.getTranslatedMessage(PRODUCT_CATEGORY_NOT_FOUND_TRANSL_KEY, product.getCategories().stream().findFirst())));

    return productCategoryRepository.getReferenceById(productCategory.getId());
  }
}
