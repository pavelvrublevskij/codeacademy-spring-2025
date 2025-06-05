package lt.codeacademy.spring2025.eshop.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DummyUserClassTest {

  @Mock
  private DummyUserService dummyService;

  @InjectMocks
  private DummyUserClass dummyUserClass;

  @Test
  public void testFindUserAgeByNameReturnsZero() {
    // given
    when(dummyService.getUserAgeByName("Dummy User (dummy)")).thenReturn(0);

    // when
    int age = dummyUserClass.findUserAgeByName("Dummy User");

    // then
    Assertions.assertEquals(0, age, "Expected age to be 0 for dummy user");
  }

  @Test
  public void testFindUserAgeByNameWhenUserNameIsNull() {
    // when
    int age = dummyUserClass.findUserAgeByName(null);

    // then
    Assertions.assertEquals(0, age, "Expected age to be 0 when user name is null");
  }

  @Test
  public void testFindUserAgeByNameWhenUserNameIsEmpty() {
    // when
    int age = dummyUserClass.findUserAgeByName("");

    // then
    Assertions.assertEquals(0, age, "Expected age to be 0 when user name is null");
  }

  @Test
  public void testSaveUserSuccess() {
    // when
    dummyUserClass.saveUser("test user");

    // then
    verify(dummyService, times(1)).saveUser(anyString());
  }

  @Test
  public void testSaveUserThrowsException() {
    // given
    doThrow(new RuntimeException("Save failed")).when(dummyService).saveUser(anyString());

    // when & then
    Assertions.assertThrows(RuntimeException.class, () -> dummyUserClass.saveUser("test user"));
  }

}
