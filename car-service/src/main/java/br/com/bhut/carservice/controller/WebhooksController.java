package br.com.bhut.carservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhook")
@Slf4j
public class WebhooksController {

    @PostMapping("/carLog")
    public void receiveLogWebhook(@RequestBody String message) {

        log.info("Webhook: " + message);
    }
}
