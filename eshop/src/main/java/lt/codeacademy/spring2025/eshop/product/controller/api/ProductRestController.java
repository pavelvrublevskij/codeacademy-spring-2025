package lt.codeacademy.spring2025.eshop.product.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.product.dto.ProductListDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductListDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductRestController {

  private final ProductService productService;
  private final ProductListDtoMapper productListDtoMapper;

  @ResponseBody
  @GetMapping
  public List<ProductListDto> getAllProducts() {
    return productService.getAllProducts().stream()
      .map(productListDtoMapper::toDto)
      .collect(Collectors.toList());
  }
}
