package lt.codeacademy.spring2025.eshop.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;

/**
 * represents a list of products with category name
 */
@Builder
public record ProductListDto(
  UUID uuid,
  String name,
  BigDecimal price,
  int amount,
  String categoryName,
  String description) {
}
