package lt.codeacademy.spring2025.eshop.cart.dto;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record CartProductDto(
  String name,
  BigDecimal unitPrice,
  int amount) {
}
