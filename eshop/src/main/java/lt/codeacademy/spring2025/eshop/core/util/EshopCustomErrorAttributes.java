package lt.codeacademy.spring2025.eshop.core.util;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class EshopCustomErrorAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest serverRequest, ErrorAttributeOptions options) {
    final Map<String, Object> errorAttributes = super.getErrorAttributes(serverRequest, options);
    errorAttributes.put("myCustomAttribute", "=== Custom Attribute ===");

    return errorAttributes;
  }
}
