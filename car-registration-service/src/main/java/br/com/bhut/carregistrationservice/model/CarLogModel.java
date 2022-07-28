package br.com.bhut.carregistrationservice.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@Document("registeredCarsLog")
public class CarLogModel {

    @Id
    private String id;

    private Date data_hora;

    private String car_id;

    public static CarLogModel convertToCarLog (CarModel carModel) {

        return CarLogModel.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .data_hora(new Date(System.currentTimeMillis()))
                .car_id(carModel.get_id())
                .build();
    }
}
