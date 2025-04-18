package lt.codeacademy.spring2025.eshop.product.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ProductDto {
  private UUID id;
	private String name;
	private double price;
	private int amount;
  private String description;
}
