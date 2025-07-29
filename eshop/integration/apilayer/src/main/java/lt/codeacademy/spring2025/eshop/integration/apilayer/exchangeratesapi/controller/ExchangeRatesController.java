package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;

@RestController
@RequiredArgsConstructor
public class ExchangeRatesController {

  private final ExchangeRatesService exchangeRatesService;

  @GetMapping("/api/integrations/exchange-rates")
  public ExchangeRatesResponse getExchangeRates() {
    return exchangeRatesService.getLatestBaseExchangeRates("EUR");
  }

}
