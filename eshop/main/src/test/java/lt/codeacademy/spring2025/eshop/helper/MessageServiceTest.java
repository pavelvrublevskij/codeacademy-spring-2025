package lt.codeacademy.spring2025.eshop.helper;

import java.util.Locale;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

  @Mock
  private MessageSource messageSource;

  @InjectMocks
  private MessageService messageService;

  @Test
  void getTranslatedMessageWhenKeyIsNullThenReturnEmptyMessage() {
    // given

    // when
    String translatedMessage = messageService.getTranslatedMessage(null);

    // then
    Assertions.assertNotNull(translatedMessage);
    Assertions.assertEquals("", translatedMessage);
  }

  @Test
  void getTranslatedMessageWhenKeyDoesNotExist() {
    // given
    final String MESSAGE_KEY = "non.existing.key";
    doThrow(NoSuchMessageException.class).when(messageSource)
      .getMessage(eq(MESSAGE_KEY), any(), any(Locale.class));

    // when
    String translatedMessage = messageService.getTranslatedMessage(MESSAGE_KEY);

    // then
    Assertions.assertNotNull(translatedMessage);
    Assertions.assertEquals("?" + MESSAGE_KEY + "?", translatedMessage);
  }

  @Test
  void getTranslatedMessageWhenKeyDoesExist() {
    // given
    final String MESSAGE_KEY = "existing.key";
    final String MESSAGE_VALUE = "Key Value";
    when(messageSource.getMessage(eq(MESSAGE_KEY), any(), any(Locale.class))).thenReturn(MESSAGE_VALUE);

    // when
    String translatedMessage = messageService.getTranslatedMessage(MESSAGE_KEY);

    // then
    Assertions.assertNotNull(translatedMessage);
    Assertions.assertEquals(MESSAGE_VALUE, translatedMessage);
  }
}