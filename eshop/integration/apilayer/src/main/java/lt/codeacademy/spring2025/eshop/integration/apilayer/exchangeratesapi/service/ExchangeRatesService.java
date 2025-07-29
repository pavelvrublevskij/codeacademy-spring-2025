package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;
import lt.codeacademy.spring2025.eshop.integration.apilayer.util.RestTemplateUtil;

import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.*;

/**
 * Service to interact with the Exchange Rates API.
 * This service fetches the latest exchange rates based on a specified base currency (EUR).
 */
@Service
public class ExchangeRatesService {

  public ExchangeRatesResponse getLatestBaseExchangeRates(final String baseCurrency) {
    final HttpHeaders requestHttpHeaders = new HttpHeaders();
    requestHttpHeaders.add(API_KEY_HEADER_NAME, API_KEY);

    return RestTemplateUtil.callGet(
      new RestTemplate(),
      URI.create(API_BASE_URL.concat(LATEST_ENDPOINT).concat("?base=".concat(baseCurrency))).toString(),
      requestHttpHeaders,
      ExchangeRatesResponse.class
    );
  }
}
