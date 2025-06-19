package lt.codeacademy.spring2025.eshop.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DummyUserServiceTest {

  @Test
  void testSaveUserThrowsRuntimeException() {
    String testUser = "testUser";
    DummyUserService dummyUserService = new DummyUserService();

    assertThrows(RuntimeException.class, () -> dummyUserService.saveUser(testUser),
      "Error saving user: " + testUser);
  }

  @Test
  void testSaveUserWhenNullThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new DummyUserService().saveUser(null),
      "User name cannot be null or empty");
  }

  @Test
  void testSaveUserWhenEmptyThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new DummyUserService().saveUser(""),
      "User name cannot be null or empty");
  }

  @Test
  void testSaveUserWhenEmptySpacesThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> new DummyUserService().saveUser("     "),
      "User name cannot be null or empty");
  }

  @Test
  void testSaveUserWhenNameMoreThan10ThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class,
      () -> new DummyUserService().saveUser("01234567890123"),
      "User name cannot be longer than 10 characters");
  }
}