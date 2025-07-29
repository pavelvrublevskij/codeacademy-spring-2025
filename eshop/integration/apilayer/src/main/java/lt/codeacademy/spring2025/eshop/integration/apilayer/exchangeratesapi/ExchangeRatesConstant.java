package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi;

public final class ExchangeRatesConstant {

  // TODO: move to application properties
  public static final String API_BASE_URL = "https://api.apilayer.com/exchangerates_data";
  public static final String API_KEY = "PKpfAK7oVAnEX6KGjZs4MRI8uO9Kj0I2";

  // The header name for the API key used for authentication
  public static final String API_KEY_HEADER_NAME = "apikey";

  // The endpoints for fetching exchange rates
  public static final String LATEST_ENDPOINT = "/latest";
}
