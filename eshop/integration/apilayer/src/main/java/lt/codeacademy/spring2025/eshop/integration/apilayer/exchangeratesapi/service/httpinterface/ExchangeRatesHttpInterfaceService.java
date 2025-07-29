package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.httpinterface;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;

import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.LATEST_ENDPOINT;

public interface ExchangeRatesHttpInterfaceService {

  @GetExchange(LATEST_ENDPOINT)
  ExchangeRatesResponse getLatestBaseExchangeRates(@RequestParam(required = true) String base,
                                                   @RequestParam(required = false) String symbols);
}
