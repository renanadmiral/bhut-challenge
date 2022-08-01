package br.com.bhut.carregistrationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebhookService {

    private final WebClient webhookClient;
    public void sendWebhook(String message) {

        webhookClient.post()
                .uri("/api/webhook/carLog")
                .contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just(message), String.class)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
