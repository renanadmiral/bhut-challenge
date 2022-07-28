package br.com.bhut.carservice.controller;

import br.com.bhut.carservice.kafka.KafkaMessageSender;
import br.com.bhut.carservice.model.CarModel;
import br.com.bhut.carservice.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private ExternalService externalService;

    @Autowired
    private KafkaMessageSender kafkaMessageSender;

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
