package io.dot.kkirieat.server.infra;

import io.dot.kkirieat.server.domain.KakaoMapClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KakaoMapApiClient implements KakaoMapClient {
    private RestTemplate restTemplate;

    public KakaoMapApiClient(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
    }


}
