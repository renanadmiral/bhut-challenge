package br.com.bhut.carservice.service;

import br.com.bhut.carservice.model.CarModel;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ExternalService {

    private final WebClient productWebClient = WebClient.create("http://api-test.bhut.com.br:3000");

    public Flux<CarModel> getAllCars() {

        return productWebClient.get()
                .uri("/api/cars")
                .retrieve()
                .bodyToFlux(CarModel.class);
    }
}
