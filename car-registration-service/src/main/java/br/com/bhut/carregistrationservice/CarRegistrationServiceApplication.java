package br.com.bhut.carregistrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
public class CarRegistrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRegistrationServiceApplication.class, args);
    }

}
