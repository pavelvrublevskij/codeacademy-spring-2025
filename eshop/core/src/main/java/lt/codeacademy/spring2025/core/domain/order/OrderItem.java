package lt.codeacademy.spring2025.core.domain.order;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderItem {

    private UUID id;
    private UUID productId;
    private String productName;
    private BigDecimal price;
    private int quantity;

    @Builder.Default
    private BigDecimal totalPrice = BigDecimal.ZERO;

    public void calculateTotalPrice() {
        if (price != null && quantity > 0) {
            totalPrice = price.multiply(BigDecimal.valueOf(quantity));
        }
    }
}