package lt.codeacademy.spring2025.eshop.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
	private String name;
	private double price;
	private int amount;
}
