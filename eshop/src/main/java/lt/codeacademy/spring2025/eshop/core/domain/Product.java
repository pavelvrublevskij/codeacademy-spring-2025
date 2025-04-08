package lt.codeacademy.spring2025.eshop.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
  private long id;
	private String name;
	private double price;
	private int amount;
  private String description;
}
