package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service;

import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;

public interface ExchangeRatesService {

  ExchangeRatesResponse getLatestBaseExchangeRates(final String baseCurrency);
}
