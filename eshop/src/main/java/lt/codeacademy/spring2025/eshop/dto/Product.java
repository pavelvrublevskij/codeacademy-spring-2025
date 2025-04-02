package lt.codeacademy.spring2025.eshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	private String name;
	private double price;
	private int amount;
}
