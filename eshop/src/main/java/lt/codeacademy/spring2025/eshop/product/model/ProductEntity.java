package lt.codeacademy.spring2025.eshop.product.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductEntity {

	private String name;
	private double price;
	private int amountInStock;
}
