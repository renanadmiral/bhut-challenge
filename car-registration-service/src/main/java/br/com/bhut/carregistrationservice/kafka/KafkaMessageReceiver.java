package br.com.bhut.carregistrationservice.kafka;

import br.com.bhut.carregistrationservice.model.CarModel;
import br.com.bhut.carregistrationservice.service.CarLogService;
import br.com.bhut.carregistrationservice.service.ExternalService;
import br.com.bhut.carregistrationservice.service.WebhookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaMessageReceiver  {

    public static final String KAFKA_TOPIC = "CAR_REGISTRATION_QUEUE";

    private final ExternalService externalService;

    private final CarLogService carLogService;

    private final WebhookService webhookService;

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "group-1")
    public void listenTopic(CarModel car) {

        log.info("Kafka message received");

        //sends new car to be posted on external API
        Optional<CarModel> optionalCar = Optional.ofNullable(
                externalService.postNewCar(car)
        );

        //Post validation, log creation and Webhook triggering
        if (optionalCar.isPresent()) {

            final String MESSAGE = "Car registered successfully";

            carLogService.saveCarLog(optionalCar.get());
            webhookService.sendWebhook(MESSAGE);
            log.info(MESSAGE);
        } else {

            final String MESSAGE = "Server error, car not saved.";

            webhookService.sendWebhook(MESSAGE);
            log.error(MESSAGE);
        }
    }
}
