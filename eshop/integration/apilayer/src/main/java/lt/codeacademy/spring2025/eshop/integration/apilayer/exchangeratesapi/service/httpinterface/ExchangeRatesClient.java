package lt.codeacademy.spring2025.eshop.integration.apilayer.exchangeratesapi.service.httpinterface;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import lombok.Getter;

@Getter
@Component
public class ExchangeRatesClient {

  private ExchangeRatesHttpInterfaceService service;
  private WebClient webClient;

  public void create(WebClient webClient) {
    this.webClient = webClient;
    final HttpServiceProxyFactory httpServiceProxyFactory =
      HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();

    service = httpServiceProxyFactory.createClient(ExchangeRatesHttpInterfaceService.class);
  }

}
