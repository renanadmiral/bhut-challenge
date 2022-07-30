package br.com.bhut.carregistrationservice.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebhookService {

    private final WebClient productWebClient = WebClient.create("http://localhost:8080");

    public void sendWebhook(String message) {

        productWebClient.post()
                .uri("/api/webhook/carLog")
                .contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just(message), String.class)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
