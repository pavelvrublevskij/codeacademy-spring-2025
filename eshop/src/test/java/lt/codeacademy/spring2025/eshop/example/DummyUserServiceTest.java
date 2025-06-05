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
}