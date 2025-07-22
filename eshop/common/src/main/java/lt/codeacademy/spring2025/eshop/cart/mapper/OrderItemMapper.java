package lt.codeacademy.spring2025.eshop.cart.mapper;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.cart.dto.OrderItemDto;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.core.domain.cart.CartItem;
import lt.codeacademy.spring2025.core.domain.order.OrderItem;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemMapper implements DomainDtoMapper<OrderItem, OrderItemDto> {

    @Override
    public OrderItemDto toDto(OrderItem domain) {
        return OrderItemDto.builder()
            .id(domain.getId())
            .productId(domain.getProductId())
            .productName(domain.getProductName())
            .price(domain.getPrice())
            .quantity(domain.getQuantity())
            .totalPrice(domain.getTotalPrice())
            .build();
    }

    @Override
    public OrderItem toDomain(OrderItemDto dto) {
        OrderItem item = OrderItem.builder()
            .id(dto.getId())
            .productId(dto.getProductId())
            .productName(dto.getProductName())
            .price(dto.getPrice())
            .quantity(dto.getQuantity())
            .totalPrice(dto.getTotalPrice())
            .build();

        return item;
    }

    public OrderItem fromCartItem(CartItem cartItem) {
        OrderItem orderItem = OrderItem.builder()
            .id(UUID.randomUUID())
            .productId(cartItem.getProduct().getId())
            .productName(cartItem.getProduct().getName())
            .price(cartItem.getProduct().getPrice())
            .quantity(cartItem.getQuantity())
            .build();

        orderItem.calculateTotalPrice();
        return orderItem;
    }
}