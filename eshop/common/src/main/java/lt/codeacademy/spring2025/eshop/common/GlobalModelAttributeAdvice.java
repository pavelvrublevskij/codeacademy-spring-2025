package lt.codeacademy.spring2025.eshop.common;

import java.time.LocalDateTime;

import lt.codeacademy.spring2025.eshop.core.util.EshopDateTimeFormatUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributeAdvice {

  @ModelAttribute("modelDateAttr")
  public String now() {
    return EshopDateTimeFormatUtil.getFormatterDateTime(LocalDateTime.now());
  }

  @ModelAttribute("euroCurrency")
  public String currency() {
    return "€";
  }
}
