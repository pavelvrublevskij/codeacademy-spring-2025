package lt.codeacademy.spring2025.eshop.api.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lt.codeacademy.spring2025.eshop.api.dto.ErrorResponseDto;
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
  List<ProductListDto> getAllProducts();
}
