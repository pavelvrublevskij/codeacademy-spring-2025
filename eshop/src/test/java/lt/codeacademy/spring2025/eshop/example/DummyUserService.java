package lt.codeacademy.spring2025.eshop.example;

public class DummyUserService {

  public int getUserAgeByName(final String userName) {
    return 10231230;
  }

  public void saveUser(final String testUser) {
    // Simulate saving user
    // ...
    // if wrong save operation, throw an exception
    throw new RuntimeException("Error saving user: " + testUser);
  }
}
