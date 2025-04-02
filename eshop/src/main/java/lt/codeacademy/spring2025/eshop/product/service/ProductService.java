package lt.codeacademy.spring2025.eshop.product.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.product.dto.ProductDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductMapper;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	public void save(final ProductDto productDto) {
		productRepository.save(productMapper.toProductEntity(productDto));
	}

	public List<ProductDto> getAllProducts() {
		return productRepository.findAll().stream()
				.map(productMapper::toProductDto)
				.toList();
	}
}
