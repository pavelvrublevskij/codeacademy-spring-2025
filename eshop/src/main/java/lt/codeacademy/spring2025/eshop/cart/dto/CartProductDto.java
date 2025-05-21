package lt.codeacademy.spring2025.eshop.cart.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;

@Builder
public record CartProductDto(
  UUID uuid,
  String name,
  BigDecimal unitPrice,
  int quantity) {
}
