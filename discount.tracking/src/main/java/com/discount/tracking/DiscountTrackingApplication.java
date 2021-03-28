package com.discount.tracking;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
public class DiscountTrackingApplication {

	@Bean
	public WebClient getWebClient()
	{
		String accessToken = "TEST-2636781233817184-081411-7301f88e48e73714f454378c557a37b3-292162037";

		return WebClient.builder()
				.baseUrl("https://api.mercadopago.com/")
				.defaultHeader(
						HttpHeaders.CONTENT_TYPE,
						MediaType.APPLICATION_JSON_VALUE,
						HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DiscountTrackingApplication.class, args);
	}

}
