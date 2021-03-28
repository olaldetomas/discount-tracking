package com.discount.tracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    WebClient webClient;

    @GetMapping
    public String getPayments() {
        // https://api.mercadopago.com/payments/search?sort=date_created&criteria=desc

        String response = webClient.get()
                .uri("v1/identification_types")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
