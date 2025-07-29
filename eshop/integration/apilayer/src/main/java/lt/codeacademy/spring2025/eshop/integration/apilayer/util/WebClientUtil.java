package lt.codeacademy.spring2025.eshop.integration.apilayer.util;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.dto.ExchangeRatesResponse;

import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.API_BASE_URL;
import static lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.ExchangeRatesConstant.LATEST_ENDPOINT;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebClientUtil {

  public static <Res> Res callGet(final String url,
                                  final String uriPath,
                                  final HttpHeaders requestHttpHeaders,
                                  final Class<Res> responseType) {
    return buildWebClientOf(url, requestHttpHeaders)
      .get()
      .uri(uriPath)
      .retrieve()
      .bodyToMono(responseType)
      .log()
      .block(); // Blocking call to wait for the response
  }

  public static WebClient buildWebClientOf(final String baseUrl, final HttpHeaders requestHttpHeaders) {
    return WebClient.builder()
      .baseUrl(baseUrl)
      .defaultHeaders(httpHeaders -> httpHeaders.addAll(requestHttpHeaders))
      .build();
  }
}
