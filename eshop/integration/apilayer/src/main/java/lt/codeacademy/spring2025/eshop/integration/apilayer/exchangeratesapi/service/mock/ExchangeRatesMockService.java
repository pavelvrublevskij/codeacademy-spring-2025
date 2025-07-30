package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.mock;

import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;

@Profile("integration & mock")
@Service
public class ExchangeRatesMockService implements ExchangeRatesService {

  @Override
  public ExchangeRatesResponse getLatestBaseExchangeRates(String baseCurrency) {
    return ExchangeRatesResponse.builder()
      .base("EUR")
      .date("2025-07-24")
      .rates(Map.of(
        "AED", 4.321333,
        "AFN", 81.767873,
        "ALL", 97.796364
      ))
      .success(true)
      .timestamp(1753382344L)
      .build();
  }
}
