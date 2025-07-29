package lt.codeacademy.spring2025.eshop.integration.apilayer.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RestTemplateUtil {

  /**
   * Calls the API using the provided RestTemplate, URL, and HTTP headers.
   *
   * @param restTemplate       the RestTemplate to use for the request
   * @param url                the URL of the API endpoint
   * @param requestHttpHeaders the HTTP headers to include in the request
   * @param responseType       the class type of the response
   * @return the response body from the API call
   */
  public static <Res> Res callGet(final RestTemplate restTemplate,
                                  final String url,
                                  final HttpHeaders requestHttpHeaders,
                                  final Class<Res> responseType) {
    try {
      return restTemplate.exchange(
        url,
        HttpMethod.GET,
        new HttpEntity<>(null, requestHttpHeaders),
        responseType
      ).getBody();
    } catch (Exception e) {
      log.error("Error calling API at URL: {}", url, e);
      throw new RuntimeException("Failed to call API", e);
    }
  }
}
