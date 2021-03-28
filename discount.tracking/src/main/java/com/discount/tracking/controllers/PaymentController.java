package com.discount.tracking.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@PropertySource("classpath:env.properties")
@RequestMapping(value = "payment")
public class PaymentController {

    @Value("${accessToken}")
    private String accessToken;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public Flux<String> getPayments() {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.mercadopago.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Flux<String> response = webClient.get()
                .uri("payments/search?sort=date_created&criteria=desc")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToFlux(String.class);

        return response;
    }
}
