package br.com.bhut.carregistrationservice.kafka;


import br.com.bhut.carregistrationservice.model.CarModel;
import br.com.bhut.carregistrationservice.service.CarLogService;
import br.com.bhut.carregistrationservice.service.WebhookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageReceiver {

    public static final String KAFKA_TOPIC = "CAR_REGISTRATION_QUEUE";

    private final CarLogService carLogService;

    private final WebhookService webhookService;


    @KafkaListener(topics = KAFKA_TOPIC, groupId = "group-1")
    public void listenTopic(CarModel car) {

        log.info("Kafka message received");

        //http post

        carLogService.saveCarLog(car);

        webhookService.sendWebhook();
    }

}
