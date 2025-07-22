package lt.codeacademy.spring2025.eshop.cart.service;

import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.cart.dto.OrderDto;
import lt.codeacademy.spring2025.eshop.cart.mapper.OrderMapper;
import lt.codeacademy.spring2025.core.domain.order.Order;
import lt.codeacademy.spring2025.core.domain.cart.Cart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    @Transactional
    public OrderDto createOrder(Cart cart) {
        if (cart == null || cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cart cannot be empty");
        }

        Order order = orderMapper.fromCart(cart);

        // In a real application, here we would save the order to the database
        // orderRepository.save(order);

        // For now, we'll just return the created order
        return orderMapper.toDto(order);
    }

    public OrderDto getOrderById(UUID id) {
        // In a real application, this would be fetched from the database
        // Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        // return orderMapper.toDto(order);

        // For now, we'll just return null since we're not persisting orders
        return null;
    }
}