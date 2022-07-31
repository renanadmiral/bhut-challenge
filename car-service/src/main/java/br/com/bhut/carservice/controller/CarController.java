package br.com.bhut.carservice.controller;

import br.com.bhut.carservice.kafka.KafkaMessageSender;
import br.com.bhut.carservice.model.CarModel;
import br.com.bhut.carservice.service.ExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarController {

    private final ExternalService externalService;

    private final KafkaMessageSender kafkaMessageSender;

    @GetMapping("/listCars")
    public Flux<CarModel> getCarsList () {

        return externalService.getAllCars();
    }

    @PostMapping("/createCar")
    @ResponseStatus(HttpStatus.CREATED)
    public CarModel postNewCar (@RequestBody CarModel car) {
        kafkaMessageSender.sendMessage(car);
        return car;
    }
}
