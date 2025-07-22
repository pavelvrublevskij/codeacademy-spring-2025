package lt.codeacademy.spring2025.eshop.product.controller;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import lt.codeacademy.spring2025.core.domain.Product;
import lt.codeacademy.spring2025.eshop.product.dto.ProductListDto;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductListDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

  private MockMvc mockMvc;

  @Mock
  private ProductService productService;
  @Mock
  private ProductListDtoMapper productListDtoMapper;

  @InjectMocks
  private ProductController productController;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(productController)
      .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
      .build();
  }

  @Test
  public void testGetProductsReturnsCorrectView() throws Exception {
    // given
    var uuid1 = UUID.randomUUID();
    var uuid2 = UUID.randomUUID();
    Page<ProductListDto> pageableProductListDtos = new PageImpl<>(
      List.of(
        ProductListDto.builder().uuid(uuid1).name("Product 1").build(),
        ProductListDto.builder().uuid(uuid2).name("Product 2").build()
      ));

    // when
    when(productService.getAllProductsPaginated(any(Pageable.class))).thenReturn(new PageImpl<>(
      List.of(
        Product.builder().id(uuid1).name("Product 1").build(),
        Product.builder().id(uuid2).name("Product 2").build()
      )
    ));

    when(productListDtoMapper.toDto(any(Product.class)))
      .thenReturn(
        pageableProductListDtos.getContent().get(0),
        pageableProductListDtos.getContent().get(1)
      );

    // then
    mockMvc.perform(MockMvcRequestBuilders.get("/products")
        .param("size", "5"))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.view().name(ProductController.PRODUCT_PRODUCTS_VIEW))
      .andExpect(MockMvcResultMatchers.model().attributeExists("productPage"))
      .andExpect(MockMvcResultMatchers.model().attribute("productPage", pageableProductListDtos));
  }

}