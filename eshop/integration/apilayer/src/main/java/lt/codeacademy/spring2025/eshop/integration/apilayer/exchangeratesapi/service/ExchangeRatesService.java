package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service;

import org.springframework.http.HttpHeaders;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;

import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API_KEY;
import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API_KEY_HEADER_NAME;

public interface ExchangeRatesService {

  ExchangeRatesResponse getLatestBaseExchangeRates(final String baseCurrency);

  default HttpHeaders getDefaultHeaders() {
    final HttpHeaders requestHttpHeaders = new HttpHeaders();
    requestHttpHeaders.add(API_KEY_HEADER_NAME, API_KEY);

    return requestHttpHeaders;
  }
}
