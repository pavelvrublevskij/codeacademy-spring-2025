package lt.codeacademy.spring2025.eshop.example;

public class DummyUserClass {

  private final DummyUserService service;

  public DummyUserClass(DummyUserService service) {
    this.service = service;
  }

  public int findUserAgeByName(String userName) {
    return service.getUserAgeByName(userName + " (dummy)");
  }
}
