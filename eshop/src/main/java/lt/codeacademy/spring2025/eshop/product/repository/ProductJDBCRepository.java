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

	}

	@Override
	public Optional<Product> findById(UUID productId) {
		return Optional.empty();
	}

	@Override
	public void deleteProductByUUID(UUID productId) {
		jdbcTemplate.execute(String.format("DELETE FROM PRODUCT WHERE PRODUCT_ID = '%s'", productId.toString()));
	}
}
