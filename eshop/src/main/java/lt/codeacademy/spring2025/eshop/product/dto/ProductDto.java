package lt.codeacademy.spring2025.eshop.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ProductDto {
	private String name;
	private double price;
	private int amount;
  private String description;
}
