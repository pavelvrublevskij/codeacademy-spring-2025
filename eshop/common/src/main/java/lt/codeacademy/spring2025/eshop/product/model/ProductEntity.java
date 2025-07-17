package lt.codeacademy.spring2025.eshop.product.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private UUID productId;
	private String name;
	private BigDecimal price;

  @Column(name = "quantity_in_stock")
	private int amountInStock;

  private String description;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
    name = "product_product_categories",
    joinColumns = { @JoinColumn(name = "product_id") },
    inverseJoinColumns = { @JoinColumn(name = "product_category_id") }
  )
  private Set<ProductCategoryEntity> productCategories = new HashSet<>();
}
