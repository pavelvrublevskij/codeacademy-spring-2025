package lt.codeacademy.spring2025.eshop.api.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.api.exception.InternalServerErrorException;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.dto.ProductListDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductDtoMapper;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductListDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductRestController implements ProductRestControllerSpec, ProductRestControllerHasSecurity {

  private final ProductService productService;
  private final ProductListDtoMapper productListDtoMapper;
  private final ProductDtoMapper productDtoMapper;

  @ResponseBody
  @GetMapping
  public List<ProductListDto> getAllProducts() {
    // Uncomment the line below to simulate an internal server error for testing purposes
//     throw new InternalServerErrorException("My custom error message for testing purposes");
    return getProductListDtos();
  }

  @ResponseBody
  @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public List<ProductListDto> getAllProductsAsXml() {
    return getProductListDtos();
  }

  private List<ProductListDto> getProductListDtos() {
    return productService.getAllProducts().stream()
      .map(productListDtoMapper::toDto)
      .collect(Collectors.toList());
  }

  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Void> createProduct(@RequestBody @Valid ProductDto productDto) {
    productService.save(productDtoMapper.toDomain(productDto));
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{uuid}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Void> deleteProduct(@PathVariable UUID uuid) {
    productService.deleteProductByUUID(uuid);
    return ResponseEntity.noContent().build();
  }

  @PutMapping
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<ProductDto> updateProduct(@RequestBody @Valid ProductDto productDto) {
    productService.update(productDtoMapper.toDomain(productDto));
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
