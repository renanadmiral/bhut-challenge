package br.com.bhut.carregistrationservice.service;

import br.com.bhut.carregistrationservice.model.CarLogModel;
import br.com.bhut.carregistrationservice.model.CarModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarLogService {

    private final MongoTemplate mongoTemplate;

    public CarLogModel saveCarLog (CarModel carModel) {

        CarLogModel newCarLog = CarLogModel.convertToCarLog(carModel);

        mongoTemplate.save(newCarLog);

        log.info("New Car Log Created");

        return newCarLog;
    }

    public List<CarLogModel> getAllCarLogs() {

        return mongoTemplate.findAll(CarLogModel.class);
    }
}
