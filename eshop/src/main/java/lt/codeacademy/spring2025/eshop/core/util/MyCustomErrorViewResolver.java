package lt.codeacademy.spring2025.eshop.core.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class MyCustomErrorViewResolver implements ErrorViewResolver {

  @Override
  public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
    if (status == HttpStatus.NOT_FOUND) {
      return new ModelAndView("error/404", model);
    }

    final Map<String, Object> myModelMap = new HashMap<>();
    myModelMap.putAll(model);
    myModelMap.put("myCustomAttribute", "Any text for attribute");
    return new ModelAndView("myCustomError", myModelMap);
  }
}
