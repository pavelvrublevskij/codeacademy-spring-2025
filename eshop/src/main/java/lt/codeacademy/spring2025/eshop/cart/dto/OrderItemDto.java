package lt.codeacademy.spring2025.eshop.cart.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderItemDto {

    private UUID id;
    private UUID productId;
    private String productName;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalPrice;
} 