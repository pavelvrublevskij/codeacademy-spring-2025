package lt.codeacademy.spring2025.core.helper;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class MessageService {

  private final MessageSource messageSource;

  /**
   * Used for message translation by provided key
   * @param key from messages translation files
   * @return Translated message by selected locale. Return ?text? if no translated key provided
   */
  public String getTranslatedMessage(String key, Object... args) {
    if (key != null) {
      try {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
      } catch (NoSuchMessageException e) {
        if (key != null && !key.equals("")) {
          log.atError().log("Translation key not found: {}", key);

          return String.format("?%s?", key);
        }
      }
    }

    return "";
  }

}
