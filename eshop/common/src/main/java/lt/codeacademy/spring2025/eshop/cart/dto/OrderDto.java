package lt.codeacademy.spring2025.eshop.cart.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderDto {

    private UUID id;
    private LocalDateTime orderDate;
    
    @Builder.Default
    private BigDecimal totalAmount = BigDecimal.ZERO;
    
    @Builder.Default
    private List<OrderItemDto> items = new ArrayList<>();
} 