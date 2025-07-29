package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.webclient;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;
import lt.codeacademy.spring2025.eshop.integration.apilayer.util.WebClientUtil;

import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.*;

/**
 * Service to interact with the Exchange Rates API using WebClient.
 * This service fetches the latest exchange rates based on a specified base currency (EUR).
 */
@Profile("integration & reactive-exchange-webclient")
@Service
public class ExchangeRatesWebClientService implements ExchangeRatesService {

  @Override
  public ExchangeRatesResponse getLatestBaseExchangeRates(String baseCurrency) {
    final HttpHeaders requestHttpHeaders = new HttpHeaders();
    requestHttpHeaders.add(API_KEY_HEADER_NAME, API_KEY);

    return WebClientUtil.callGet(
      API_BASE_URL,
      LATEST_ENDPOINT.concat("?base=").concat(baseCurrency),
      requestHttpHeaders,
      ExchangeRatesResponse.class
    );
  }
}
