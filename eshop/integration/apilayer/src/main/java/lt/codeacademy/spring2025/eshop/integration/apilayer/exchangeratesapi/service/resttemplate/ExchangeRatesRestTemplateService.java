package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.resttemplate;

import java.net.URI;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;
import lt.codeacademy.spring2025.eshop.integration.apilayer.util.RestTemplateUtil;

import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.*;

/**
 * Service to interact with the Exchange Rates API.
 * This service fetches the latest exchange rates based on a specified base currency (EUR).
 */
@Profile("integration & rest-template")
@Service
public class ExchangeRatesRestTemplateService implements ExchangeRatesService {

  public ExchangeRatesResponse getLatestBaseExchangeRates(final String baseCurrency) {
    return RestTemplateUtil.callGet(
      new RestTemplate(),
      URI.create(API_BASE_URL.concat(LATEST_ENDPOINT).concat("?base=".concat(baseCurrency))).toString(),
      getDefaultHeaders(),
      ExchangeRatesResponse.class
    );
  }
}
