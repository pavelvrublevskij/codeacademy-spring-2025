package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;

@Repository
@RequiredArgsConstructor
public class ProductJDBCRepository implements ProductRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public void save(Product product) {
    jdbcTemplate.update(
      "INSERT INTO product (product_id, name, quantity_in_stock, price, description) VALUES (?, ?, ?, ?, ?)",
      product.getId(), product.getName(), product.getAmount(), product.getPrice(), product.getDescription());
  }

  @Override
  public List<Product> findAll() {
    return jdbcTemplate.query("SELECT * FROM PRODUCT",
      (resultSet, rowNum) -> Product.builder()
        .id(UUID.fromString(resultSet.getString("PRODUCT_ID")))
        .name(resultSet.getString("NAME"))
        .price(resultSet.getDouble("PRICE"))
        .amount(resultSet.getInt("QUANTITY_IN_STOCK"))
        .description(resultSet.getString("DESCRIPTION"))
        .build());
  }

  @Override
  public void update(Product product) {
    jdbcTemplate.update("UPDATE product SET name = ?, price = ?, quantity_in_stock = ?, description = ? WHERE PRODUCT_ID = ?",
      product.getName(), product.getPrice(), product.getAmount(), product.getDescription(), product.getId());
  }

  @Override
  public Optional<Product> findById(UUID productId) {
    return jdbcTemplate.query(String.format("SELECT * FROM product WHERE product_id = '%s'", productId.toString()),
      (resultSet, rowNum) -> Product.builder()
        .id(UUID.fromString(resultSet.getString("PRODUCT_ID")))
        .name(resultSet.getString("NAME"))
        .price(resultSet.getDouble("PRICE"))
        .amount(resultSet.getInt("QUANTITY_IN_STOCK"))
        .description(resultSet.getString("DESCRIPTION"))
        .build()).stream()
      .findFirst();
  }

  @Override
  public void deleteProductByUUID(UUID productId) {
    jdbcTemplate.execute(String.format("DELETE FROM PRODUCT WHERE PRODUCT_ID = '%s'", productId.toString()));
  }
}
