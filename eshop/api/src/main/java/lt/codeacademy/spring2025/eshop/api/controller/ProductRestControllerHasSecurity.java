package lt.codeacademy.spring2025.eshop.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lt.codeacademy.spring2025.eshop.api.dto.ErrorResponseDto;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.dto.ProductListDto;

public interface ProductRestControllerHasSecurity {

  List<ProductListDto> getAllProducts();

  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  List<ProductListDto> getAllProductsAsXml();

  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  ResponseEntity<Void> createProduct(@RequestBody @Valid ProductDto productDto);

  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  ResponseEntity<Void> deleteProduct(@PathVariable UUID uuid);

  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  ResponseEntity<ProductDto> updateProduct(@RequestBody @Valid ProductDto productDto);
}
