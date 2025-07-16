package lt.codeacademy.spring2025.eshop.example;

public class DummyUserClass {

  private final DummyUserService service;

  public DummyUserClass(DummyUserService service) {
    this.service = service;
  }

  public int findUserAgeByName(String userName) {
    if (userName == null || userName.isEmpty()) {
      return 0;
    }

    return service.getUserAgeByName(userName + " (dummy)");
  }

  public void saveUser(final String testUser) {
    service.saveUser(testUser);
  }
}
