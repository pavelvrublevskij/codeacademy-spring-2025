package lt.codeacademy.spring2025.eshop.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

public interface ProductRestControllerSpec {

  @Operation(
    summary = "Get all products",
    description = "Returns a list of all products in the system. And put here more other information if needed bla bla bla.")
  @ApiResponses(value = {
    @ApiResponse(
      responseCode = "200",
      description = "Successfully retrieved the list of products",
      content = @Content(
        mediaType = "application/json",
        array = @ArraySchema(schema = @Schema(implementation = ProductListDto.class))
      )
    ),
    @ApiResponse(
      responseCode = "500",
      description = "Internal server error",
      content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = ErrorResponseDto.class)
      )
    )
  })
  @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
  List<ProductListDto> getAllProducts();

  @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
  List<ProductListDto> getAllProductsAsXml();

  @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
  ResponseEntity<Void> createProduct(@RequestBody @Valid ProductDto productDto);

  @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
  ResponseEntity<Void> deleteProduct(@PathVariable UUID uuid);

  @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
  ResponseEntity<ProductDto> updateProduct(@RequestBody @Valid ProductDto productDto);
}
