package lt.codeacademy.spring2025.eshop.product.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.dto.ProductListDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductDtoMapper;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductListDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductRestController {

  private final ProductService productService;
  private final ProductListDtoMapper productListDtoMapper;
  private final ProductDtoMapper productDtoMapper;

  @ResponseBody
  @GetMapping
  public List<ProductListDto> getAllProducts() {
    return getProductListDtos();
  }

  @ResponseBody
  @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
  public List<ProductListDto> getAllProductsAsXml() {
    return getProductListDtos();
  }

  private List<ProductListDto> getProductListDtos() {
    return productService.getAllProducts().stream()
      .map(productListDtoMapper::toDto)
      .collect(Collectors.toList());
  }

  @PostMapping
  public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductDto productDto) {
    productService.save(productDtoMapper.toDomain(productDto));
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
