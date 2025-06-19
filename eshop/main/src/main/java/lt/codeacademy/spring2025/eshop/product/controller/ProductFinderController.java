package lt.codeacademy.spring2025.eshop.product.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.product.mapper.ProductListDtoMapper;
import lt.codeacademy.spring2025.eshop.product.service.ProductFinderService;

import static lt.codeacademy.spring2025.eshop.HttpEndpoint.PRODUCTS_FIND;
import static lt.codeacademy.spring2025.eshop.product.controller.ProductController.PRODUCT_PRODUCTS_VIEW;

@Controller
@RequestMapping(PRODUCTS_FIND)
@RequiredArgsConstructor
public class ProductFinderController {

  private final ProductFinderService productFinderService;
  private final ProductListDtoMapper productListDtoMapper;

  @GetMapping
  public String findProductsByName(Model model, @RequestParam String productName, Pageable pageable) {
    model.addAttribute("productPage",
      productFinderService.findProductsByNamePageable(productName, pageable)
        .map(productListDtoMapper::toDto));
    return PRODUCT_PRODUCTS_VIEW;
  }
}
