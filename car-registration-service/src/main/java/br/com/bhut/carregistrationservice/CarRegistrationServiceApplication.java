package br.com.bhut.carregistrationservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CarRegistrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRegistrationServiceApplication.class, args);
    }

    @Bean
    public WebClient webhookClient(
            WebClient.Builder builder,
            @Value(value = "${webhook.service.adress}") String adress
    ) {
        return builder
                .baseUrl(adress)
                .build();
    }
}
