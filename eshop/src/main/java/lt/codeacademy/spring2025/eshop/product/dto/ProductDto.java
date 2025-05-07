package lt.codeacademy.spring2025.eshop.product.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
  @Positive(message = "{amount.positive}")
  @NotNull
	private int amount;
  private String description;
}
