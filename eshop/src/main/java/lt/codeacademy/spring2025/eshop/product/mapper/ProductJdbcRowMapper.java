package lt.codeacademy.spring2025.eshop.product.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import lt.codeacademy.spring2025.eshop.core.domain.Product;

@Component
public class ProductJdbcRowMapper implements RowMapper<Product> {

  @Override
  public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
    return Product.builder()
      .id(UUID.fromString(rs.getString("PRODUCT_ID")))
      .name(rs.getString("NAME"))
      .price(rs.getDouble("PRICE"))
      .amount(rs.getInt("QUANTITY_IN_STOCK"))
      .description(rs.getString("DESCRIPTION"))
      .build();
  }
}
