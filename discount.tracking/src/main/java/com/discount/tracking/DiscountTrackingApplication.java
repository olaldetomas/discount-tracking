package com.discount.tracking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@PropertySource("classpath:env.properties")
public class DiscountTrackingApplication {

    @Value("${ACCESS_TOKEN}")
    private String ACCESS_TOKEN;

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl("https://api.mercadopago.com/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(DiscountTrackingApplication.class, args);
    }
}
