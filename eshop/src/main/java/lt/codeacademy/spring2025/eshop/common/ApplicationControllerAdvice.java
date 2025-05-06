package lt.codeacademy.spring2025.eshop.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lt.codeacademy.spring2025.eshop.common.exception.EshopNotFoundException;

@ControllerAdvice
public class ApplicationControllerAdvice {

  @ExceptionHandler
  public String notFound(EshopNotFoundException e, Model model) {
    model.addAttribute("errorMessage", e.getMessage());
    return "common/error/notFound";
  }
}
