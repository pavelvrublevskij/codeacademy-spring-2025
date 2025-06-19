package lt.codeacademy.spring2025.eshop.integration;

import java.util.List;

import lt.codeacademy.spring2025.eshop.product.model.ProductEntity;
import lt.codeacademy.spring2025.eshop.product.repository.ProductRepository;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
//@WithMockUser(roles = {"ADMIN"}) // use this instead of @WithUserDetails if you want to mock a user with specific roles, this works if you use not custom user details and user details service
@WithUserDetails(value = "admin@eshop.lt")
public class ProductControllerITest {

  public static final String FORM_MODEL_NAME = "productDto";

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void testCreateProductEmptyBodyReturnValidationErrorHappyPath() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/products/create")
        .with(SecurityMockMvcRequestPostProcessors.csrf()))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.model().hasErrors())
      .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrorCode(FORM_MODEL_NAME, "amount", "typeMismatch"))
      .andExpect(MockMvcResultMatchers.view().name("product/productCreate"));
  }

  @Test
  public void testCreateProductWithBodyHappyPath() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/products/create")
        .with(SecurityMockMvcRequestPostProcessors.csrf())
        .content(
          EntityUtils.toString(
            new UrlEncodedFormEntity(
              List.of(new BasicNameValuePair("name", "Test Product"),
                new BasicNameValuePair("price", "100.00"),
                new BasicNameValuePair("amount", "10"),
                new BasicNameValuePair("categoryId", "1"), // assuming categoryId 1 exists
                new BasicNameValuePair("description", "Test Description")
              )
            )
          )
        ).contentType(MediaType.APPLICATION_FORM_URLENCODED))
      .andExpect(MockMvcResultMatchers.status().is3xxRedirection());

    final List<ProductEntity> allProducts = productRepository.findAll();

    Assertions.assertEquals(1, allProducts.size(), "Should have one product in the database");
    ProductEntity product = allProducts.get(0);
    Assertions.assertNotNull(product.getId(), "Product ID should not be null");
    Assertions.assertNotNull(product.getProductId(), "Product UUID should not be null");
    Assertions.assertEquals("Test Product", product.getName(), "Product name should match");
    Assertions.assertEquals("100.00", product.getPrice().toString(), "Product price should match");
    Assertions.assertEquals(10, product.getAmountInStock(), "Product amount should match");
    Assertions.assertEquals("Test Description", product.getDescription(), "Product description should match");
  }

}
