package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.httpinterface;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.ExchangeRatesService;
import lt.codeacademy.spring2025.eshop.integration.apilayer.util.WebClientUtil;

import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.*;

@Profile("integration & reactive-exchange-interface")
@Service
@RequiredArgsConstructor
public class ExchangeRatesClientService implements ExchangeRatesService {

  private final ExchangeRatesClient exchangeRatesClient;

  @Override
  public ExchangeRatesResponse getLatestBaseExchangeRates(String baseCurrency) {
    final HttpHeaders requestHttpHeaders = new HttpHeaders();
    requestHttpHeaders.add(API_KEY_HEADER_NAME, API_KEY);

    exchangeRatesClient.create(WebClientUtil.buildWebClientOf(API_BASE_URL, requestHttpHeaders));

    return exchangeRatesClient.getService().getLatestBaseExchangeRates(baseCurrency, null);
  }

}
