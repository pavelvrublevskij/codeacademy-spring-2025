package lt.codeacademy.spring2025.eshop.example;

public class DummyUserService {

  public int getUserAgeByName(final String userName) {
    return 10231230;
  }

  public void saveUser(final String testUser) {
    if (testUser == null) {
      throw new IllegalArgumentException("User name cannot be null or empty");
    }

    var userName = testUser.trim();
    if (userName.isEmpty()) {
      throw new IllegalArgumentException("User name cannot be null or empty");
    }

    if (userName.length() > 10) {
      throw new IllegalArgumentException("User name cannot be longer than 10 characters");
    }

    // Simulate saving user
    // ...
    // if wrong save operation, throw an exception
    throw new RuntimeException("Error saving user: " + userName);
  }
}
