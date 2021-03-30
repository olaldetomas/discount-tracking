package com.discount.tracking.Services;

import com.discount.tracking.models.ResponsePayment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@PropertySource("classpath:env.properties")
@Service
public class PaymentService {

    @Value("${accessToken}")
    private String accessToken;

    public ResponsePayment getPaymentsFromMercadoPago() {
        String uri = "payments/search?sort=date_created&criteria=desc";

        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.mercadopago.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        return webClient.get()
                .uri(uri)
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(ResponsePayment.class).block();
    }
}
