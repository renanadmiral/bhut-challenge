package br.com.bhut.carservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webhook")
@Slf4j
public class WebhooksController {

    @PostMapping("/carLog")
    public void receiveLogWebhook() {

        log.info("Car registered successfully");
    }
}
