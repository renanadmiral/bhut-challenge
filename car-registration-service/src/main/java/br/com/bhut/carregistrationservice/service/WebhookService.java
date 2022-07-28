package br.com.bhut.carregistrationservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebhookService {

    private final WebClient productWebClient = WebClient.create("http://localhost:8080");

    public void sendWebhook() {

        productWebClient.post()
                .uri("/api/webhook/carLog")
                .retrieve();
    }
}
