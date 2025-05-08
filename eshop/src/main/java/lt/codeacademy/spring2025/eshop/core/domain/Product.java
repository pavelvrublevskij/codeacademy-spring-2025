package lt.codeacademy.spring2025.eshop.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Product {
  @Setter
  private UUID id;
	private String name;
	private BigDecimal price;
	private int amount;
  private String description;

  public UUID getId() {
    return id != null ? id : UUID.randomUUID();
  }
}
