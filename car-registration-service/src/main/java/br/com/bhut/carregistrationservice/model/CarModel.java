package br.com.bhut.carregistrationservice.model;

import lombok.*;

@Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Builder
public class CarModel {

    private String _id;

    private String title;

    private String brand;

    private String price;

    private Integer age;

    private  Integer __v;
}