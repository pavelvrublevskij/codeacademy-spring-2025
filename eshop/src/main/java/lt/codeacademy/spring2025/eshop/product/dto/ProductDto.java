package lt.codeacademy.spring2025.eshop.product.dto;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
  @NotBlank(message = "{productdto.name.notblank}")
	private String name;
  @Positive(message = "{productdto.price.positive}")
	private double price;
  @Positive(message = "{productdto.amount.positive}")
  @NotNull
  @Max(value = 10000)
	private int amount;
  @NotBlank(message = "{productdto.description.notblank}")
  @Size(min = 10, message = "{productdto.description.min}")
  private String description;
}
