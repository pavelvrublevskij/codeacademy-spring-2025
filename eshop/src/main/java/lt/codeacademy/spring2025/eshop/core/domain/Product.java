package lt.codeacademy.spring2025.eshop.core.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
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
	private int amount; // quantity/amount in stock
  private String description;
  @Builder.Default
  private Set<ProductCategory> categories = new HashSet<>();

  public UUID getId() {
    return id != null ? id : UUID.randomUUID();
  }
}
