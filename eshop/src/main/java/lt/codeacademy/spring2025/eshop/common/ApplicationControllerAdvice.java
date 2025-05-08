package lt.codeacademy.spring2025.eshop.common;

import java.time.LocalDateTime;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import lt.codeacademy.spring2025.eshop.common.exception.EshopNotFoundException;
import lt.codeacademy.spring2025.eshop.core.util.EshopDateTimeFormatUtil;

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

  @ModelAttribute("modelDateAttr")
  public String now() {
    return EshopDateTimeFormatUtil.getFormatterDateTime(LocalDateTime.now());
  }
}
