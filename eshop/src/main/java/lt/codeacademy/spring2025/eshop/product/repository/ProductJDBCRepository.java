package lt.codeacademy.spring2025.eshop.product.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductJdbcRowMapper;

@Repository
@RequiredArgsConstructor
public class ProductJDBCRepository implements ProductRepository {

  private final JdbcTemplate jdbcTemplate;
  private final ProductJdbcRowMapper productJdbcRowMapper;

  @Override
  public void save(Product product) {
    jdbcTemplate.update(
      "INSERT INTO product (product_id, name, quantity_in_stock, price, description) VALUES (?, ?, ?, ?, ?)",
      product.getId(), product.getName(), product.getAmount(), product.getPrice(), product.getDescription());
  }

  @Override
  public List<Product> findAll() {
    return jdbcTemplate.query("SELECT * FROM PRODUCT", productJdbcRowMapper);
  }

  @Override
  public void update(Product product) {
    jdbcTemplate.update("UPDATE product SET name = ?, price = ?, quantity_in_stock = ?, description = ? WHERE PRODUCT_ID = ?",
      product.getName(), product.getPrice(), product.getAmount(), product.getDescription(), product.getId());
  }

  @Override
  public Optional<Product> findById(UUID productId) {
    return jdbcTemplate.query(String.format("SELECT * FROM product WHERE product_id = '%s'", productId.toString()), productJdbcRowMapper)
      .stream()
      .findFirst();
  }

  @Override
  public void deleteProductByUUID(UUID productId) {
    jdbcTemplate.execute(String.format("DELETE FROM PRODUCT WHERE PRODUCT_ID = '%s'", productId.toString()));
  }
}
