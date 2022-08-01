package br.com.bhut.carregistrationservice.service;

import br.com.bhut.carregistrationservice.model.CarModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExternalService {

    private final WebClient externalWebClient = WebClient.create("http://api-test.bhut.com.br:3000");

    //tries to post a new car, if fails, return an empty object.
    public CarModel postNewCar(CarModel carModel) {

        return externalWebClient.post()
                .uri("/api/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(carModel), CarModel.class)
                .retrieve()
                .bodyToMono(CarModel.class)
                .onErrorResume(WebClientResponseException.class,
                    ex -> ex.getRawStatusCode() == 500 ? Mono.empty() : Mono.error(ex))
                .block();
    }
}
