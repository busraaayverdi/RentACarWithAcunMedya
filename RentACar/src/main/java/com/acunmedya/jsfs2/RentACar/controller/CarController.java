package com.acunmedya.jsfs2.RentACar.controller;


import com.acunmedya.jsfs2.RentACar.service.abstracts.CarService;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.GetListCarResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(CreateCarRequest request){
        return carService.add(request);
    }

    @GetMapping("/{modelYear}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCarResponse> findByModelYearGreaterThanEqual(@PathVariable int modelYear){
        return carService.findByModelYearGreaterThanEqual(modelYear);
    }

    @GetMapping("findByPlate/{partialPlate}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListCarResponse> findByPlateContainingIgnoreCase(@PathVariable String partialPlate){
        return carService.findByPlateContainingIgnoreCase(partialPlate);
    }
}
