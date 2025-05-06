package lt.codeacademy.spring2025.eshop.product.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.HttpEndpoint;
import lt.codeacademy.spring2025.eshop.helper.MessageService;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.exception.ProductNotFoundException;
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
  private final MessageService messageService;

	@GetMapping(HttpEndpoint.PRODUCTS)
	public String getProducts(Model model, @PageableDefault(size = 5, sort={"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
    final Page<ProductDto> pageableProductDto = productService.getAllProductsPaginated(pageable).map(productDtoMapper::toProductDto);
    model.addAttribute("productPage", pageableProductDto);
		return PRODUCT_PRODUCTS_VIEW;
	}

	@GetMapping(HttpEndpoint.PRODUCTS_CREATE)
	public String openProductForCreate(Model model) {
		model.addAttribute("product", ProductDto.builder().build());
		return PRODUCT_CREATE_VIEW;
	}

	@PostMapping(HttpEndpoint.PRODUCTS_CREATE)
	public String createProduct(ProductDto product, RedirectAttributes redirectAttributes) {
		productService.save(productDtoMapper.toProduct(product));
    redirectAttributes.addFlashAttribute("message", messageService.getTranslatedMessage("product.create.message.success"));
		return "redirect:" + HttpEndpoint.PRODUCTS_CREATE;
	}

  @GetMapping(HttpEndpoint.PRODUCT_UPDATE)
  public String updateProduct(Model model,
                              @PathVariable UUID productId) {
    model.addAttribute("product", productService.getProductById(productId));
    return PRODUCT_UPDATE_VIEW;
  }

  @PostMapping(HttpEndpoint.PRODUCT_UPDATE)
  public String updateProduct(ProductDto product,
                              @PathVariable UUID productId,
                              RedirectAttributes redirectAttributes) {
    product.setId(productId);
    productService.update(productDtoMapper.toProduct(product));
    redirectAttributes.addFlashAttribute("message", messageService.getTranslatedMessage("product.edit.message.success"));
    redirectAttributes.addFlashAttribute("productId", productId);
    return "redirect:" + HttpEndpoint.PRODUCT_UPDATE;
  }

  @GetMapping(HttpEndpoint.PRODUCTS_DELETE)
  public String deleteProduct(Model model, @PathVariable UUID productId, Pageable pageable) {
    productService.deleteProductByUUID(productId);

    return getProducts(model, pageable);
  }

}
