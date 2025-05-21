package lt.codeacademy.spring2025.eshop.common;

import lt.codeacademy.spring2025.eshop.common.exception.EshopNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class ApplicationControllerAdvice {

  @ExceptionHandler
  public String notFound(EshopNotFoundException e, Model model) {
    model.addAttribute("errorMessage", e.getMessage());
    return "common/error/notFound";
  }

  @InitBinder
  public void initBinder(WebDataBinder webDataBinder) {
    webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }
}
