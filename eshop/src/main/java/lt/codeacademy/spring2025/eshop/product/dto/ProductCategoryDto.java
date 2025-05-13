package lt.codeacademy.spring2025.eshop.product.dto;

import lombok.Builder;

@Builder
public record ProductCategoryDto(int id, String name) {
}
