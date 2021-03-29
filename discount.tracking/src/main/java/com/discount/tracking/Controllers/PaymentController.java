package com.discount.tracking.Controllers;

import com.discount.tracking.Dto.IdentificationTypesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@PropertySource("classpath:env.properties")
@RequestMapping(value = "payment")
public class PaymentController {

    @Value("${accessToken}")
    private String accessToken;

    @GetMapping
    public ResponseEntity<Mono<IdentificationTypesResponse[]>> getPayments() {

        //String uri = "payments/search?sort=date_created&criteria=desc";
        String uri = "v1/identification_types";

        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.mercadopago.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<IdentificationTypesResponse[]> response = webClient.get()
                .uri(uri)
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(IdentificationTypesResponse[].class);

            return new ResponseEntity<>(response, HttpStatus.OK) ;
    }
}
