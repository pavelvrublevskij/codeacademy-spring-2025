package lt.codeacademy.spring2025.eshop.cart.mapper;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.cart.dto.OrderDto;
import lt.codeacademy.spring2025.eshop.common.mapper.DomainDtoMapper;
import lt.codeacademy.spring2025.eshop.core.domain.cart.Cart;
import lt.codeacademy.spring2025.eshop.core.domain.order.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper implements DomainDtoMapper<Order, OrderDto> {

    private final OrderItemMapper orderItemMapper;

    @Override
    public OrderDto toDto(Order domain) {
        return OrderDto.builder()
            .id(domain.getId())
            .orderDate(domain.getOrderDate())
            .totalAmount(domain.getTotalAmount())
            .items(domain.getItems().stream()
                .map(orderItemMapper::toDto)
                .toList())
            .build();
    }

    @Override
    public Order toDomain(OrderDto dto) {
        return Order.builder()
            .id(dto.getId())
            .orderDate(dto.getOrderDate())
            .totalAmount(dto.getTotalAmount())
            .items(dto.getItems().stream()
                .map(orderItemMapper::toDomain)
                .collect(Collectors.toList()))
            .build();
    }

    public Order fromCart(Cart cart) {
        Order order = Order.builder()
            .id(UUID.randomUUID())
            .orderDate(LocalDateTime.now())
            .build();

        cart.getItems().forEach(cartItem -> {
            var orderItem = orderItemMapper.fromCartItem(cartItem);
            order.addItem(orderItem);
        });

        return order;
    }
}