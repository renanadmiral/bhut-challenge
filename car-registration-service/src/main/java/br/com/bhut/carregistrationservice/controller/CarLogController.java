package br.com.bhut.carregistrationservice.controller;

import br.com.bhut.carregistrationservice.model.CarLogModel;
import br.com.bhut.carregistrationservice.service.CarLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/logs")
@RequiredArgsConstructor
public class CarLogController {

    private final CarLogService carLogService;

    @GetMapping
    public List<CarLogModel> getAllCarLogs() {

        return carLogService.getAllCarLogs();
    }
}
