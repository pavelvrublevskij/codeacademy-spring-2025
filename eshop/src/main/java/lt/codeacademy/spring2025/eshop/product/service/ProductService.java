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
import lt.codeacademy.spring2025.eshop.core.domain.ProductCategory;
import lt.codeacademy.spring2025.eshop.helper.MessageService;
import lt.codeacademy.spring2025.eshop.product.exception.ProductNotFoundException;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductEntityMapper;
import lt.codeacademy.spring2025.eshop.product.model.ProductCategoryEntity;
import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;
import lt.codeacademy.spring2025.eshop.product.repository.ProductCategoryRepository;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductService {

  public static final String PRODUCT_NOT_FOUND_TRANSL_KEY = "product.exception.not.found";
  public static final String PRODUCT_CATEGORY_NOT_FOUND_TRANSL_KEY = "product.category.exception.not.found";

  private final ProductRepository productRepository;
  private final ProductCategoryRepository productCategoryRepository;
  private final ProductEntityMapper productEntityMapper;
  private final MessageService messageService;

  @Transactional
  public void save(final Product product) {
    final ProductCategoryEntity category = getFirstCategory(product);
    final ProductEntity productEntity = productEntityMapper.toProductEntity(product);
    productEntity.getProductCategories().add(category);

    productRepository.save(productEntity);
  }

  private ProductCategoryEntity getFirstCategory(final Product product) {
    final ProductCategory productCategory = product.getCategories().stream().findFirst()
      .orElseThrow(() -> new ProductNotFoundException(
        messageService.getTranslatedMessage(PRODUCT_CATEGORY_NOT_FOUND_TRANSL_KEY, product.getCategories().stream().findFirst())));

    return productCategoryRepository.getReferenceById(productCategory.getId());
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
      .orElseThrow(() -> new ProductNotFoundException(messageService.getTranslatedMessage(PRODUCT_NOT_FOUND_TRANSL_KEY, productId)));
  }

  @Transactional
  public void deleteProductByUUID(final UUID productId) {
    productRepository.deleteByProductId(productId);
  }
}
