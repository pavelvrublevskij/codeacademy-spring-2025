package lt.codeacademy.spring2025.eshop.product.controller;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.core.helper.MessageService;
import lt.codeacademy.spring2025.eshop.product.dto.ProductCategoryDto;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.dto.ProductListDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductCategoryDtoMapper;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductDtoMapper;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductListDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductCategoryService;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ProductController {

  public static final String PRODUCT_CREATE_VIEW = "product/productCreate";
  public static final String PRODUCT_UPDATE_VIEW = "product/productUpdate";
  public static final String PRODUCT_PRODUCTS_VIEW = "product/products";
  private final ProductService productService;
	private final ProductDtoMapper productDtoMapper;
  private final ProductListDtoMapper productListDtoMapper;
  private final ProductCategoryService productCategoryService;
  private final ProductCategoryDtoMapper productCategoryDtoMapper;
  private final MessageService messageService;

	@GetMapping(HttpEndpoint.PRODUCTS)
	public String getProducts(Model model, @PageableDefault(size = 5, sort={"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
    final Page<ProductListDto> pageableProductListDto =
      productService.getAllProductsPaginated(pageable)
        .map(productListDtoMapper::toDto);
    model.addAttribute("productPage", pageableProductListDto);
		return PRODUCT_PRODUCTS_VIEW;
	}

  @PreAuthorize("hasRole('ADMIN')")
	@GetMapping(HttpEndpoint.PRODUCTS_CREATE)
	public String openProductForCreate(Model model) {
    final Set<ProductCategoryDto> productCategories = productCategoryService.getCategories().stream()
      .map(productCategoryDtoMapper::toDto)
      .collect(Collectors.toSet());

    model.addAttribute("productCategoryDtos", productCategories);
		model.addAttribute("productDto", ProductDto.builder().build());
		return PRODUCT_CREATE_VIEW;
	}

  @PreAuthorize("hasRole('ADMIN')")
	@PostMapping(HttpEndpoint.PRODUCTS_CREATE)
	public String createProduct(@Valid ProductDto productDto, BindingResult error, Model model, RedirectAttributes redirectAttributes) {
		if (error.hasErrors()) {
     return PRODUCT_CREATE_VIEW;
   }
    productService.save(productDtoMapper.toDomain(productDto));
    redirectAttributes.addFlashAttribute("message", messageService.getTranslatedMessage("product.create.message.success"));
		return "redirect:" + HttpEndpoint.PRODUCTS_CREATE;
	}

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(HttpEndpoint.PRODUCT_UPDATE)
  public String updateProduct(Model model,
                              @PathVariable UUID productId) {
    model.addAttribute("product", productService.getProductById(productId));
    return PRODUCT_UPDATE_VIEW;
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping(HttpEndpoint.PRODUCT_UPDATE)
  public String updateProduct(ProductDto product,
                              @PathVariable UUID productId,
                              RedirectAttributes redirectAttributes) {
    product.setId(productId);
    productService.update(productDtoMapper.toDomain(product));
    redirectAttributes.addFlashAttribute("message", messageService.getTranslatedMessage("product.edit.message.success"));
    redirectAttributes.addFlashAttribute("productId", productId);
    return "redirect:" + HttpEndpoint.PRODUCT_UPDATE;
  }

  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping(HttpEndpoint.PRODUCTS_DELETE)
  public String deleteProduct(Model model, @PathVariable UUID productId, Pageable pageable) {
    productService.deleteProductByUUID(productId);

    return getProducts(model, pageable);
  }
}
