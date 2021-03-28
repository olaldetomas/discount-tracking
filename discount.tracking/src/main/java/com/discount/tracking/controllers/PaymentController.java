package com.discount.tracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    WebClient webClient;

    @GetMapping
    public String getPayments() {
        // https://api.mercadopago.com/payments/search?sort=date_created&criteria=desc

        String response = webClient.get()
                .uri("payments/search?sort=date_created&criteria=desc")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
