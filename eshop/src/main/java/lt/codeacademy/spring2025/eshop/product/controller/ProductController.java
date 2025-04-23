package lt.codeacademy.spring2025.eshop.product.controller;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductController {

  public static final String PRODUCT_CREATE_VIEW = "product/productCreate";
  public static final String PRODUCT_UPDATE_VIEW = "product/productUpdate";
  public static final String PRODUCT_PRODUCTS_VIEW = "product/products";
  private final ProductService productService;
	private final ProductDtoMapper productDtoMapper;

	@GetMapping(HttpEndpoint.PRODUCTS)
	public String getProducts(Model model, @PageableDefault(size = 2) Pageable pageable) {
		model.addAttribute("productPage", productService.getAllProductsPaginated(pageable).stream().map(productDtoMapper::toProductDto).toList());
		return PRODUCT_PRODUCTS_VIEW;
	}

	@GetMapping(HttpEndpoint.PRODUCTS_CREATE)
	public String openProductForCreate(Model model) {
		model.addAttribute("product", ProductDto.builder().build());
		return PRODUCT_CREATE_VIEW;
	}

	@PostMapping(HttpEndpoint.PRODUCTS_CREATE)
	public String createProduct(Model model, ProductDto product) {
		productService.save(productDtoMapper.toProduct(product));
    model.addAttribute("message", "Product added successfully!");
		return openProductForCreate(model);
	}

  @GetMapping(HttpEndpoint.PRODUCT_UPDATE)
  public String updateProduct(Model model,
                              @PathVariable UUID productId) {
    model.addAttribute("product", productService.getProductById(productId));
    return PRODUCT_UPDATE_VIEW;
  }

  @PostMapping(HttpEndpoint.PRODUCT_UPDATE)
  public String updateProduct(Model model,
                              ProductDto product,
                              @PathVariable UUID productId) {
    product.setId(productId);
    productService.update(productDtoMapper.toProduct(product));
    model.addAttribute("message", "Product updated successfully!");
    return updateProduct(model, productId);
  }

  @GetMapping(HttpEndpoint.PRODUCTS_DELETE)
  public String deleteProduct(Model model, @PathVariable UUID productId, Pageable pageable) {
    productService.deleteProductByUUID(productId);

    return getProducts(model, pageable);
  }
}
