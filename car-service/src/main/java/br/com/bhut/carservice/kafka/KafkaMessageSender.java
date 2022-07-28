package br.com.bhut.carservice.kafka;

import br.com.bhut.carservice.model.CarModel;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessageSender {

    private final KafkaTemplate<String, CarModel> kafkaTemplate;

    public static final String KAFKA_TOPIC = "CAR_REGISTRATION_QUEUE";

    public void sendMessage(CarModel car) {
        kafkaTemplate.send(KAFKA_TOPIC, car);
    }
}
