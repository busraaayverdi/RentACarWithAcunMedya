package com.acunmedya.jsfs2.RentACar.service.concretes;

import com.acunmedya.jsfs2.RentACar.entitiy.Car;
import com.acunmedya.jsfs2.RentACar.repository.CarRepository;
import com.acunmedya.jsfs2.RentACar.service.abstracts.CarService;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.GetListCarResponse;
import com.acunmedya.jsfs2.RentACar.service.mappers.CarMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public CreatedCarResponse add(CreateCarRequest request) {
        Car car = CarMapper.INSTANCE.carFromCreateCarRequest(request);
        Car createdCar = carRepository.save(car);
        CreatedCarResponse response = CarMapper.INSTANCE.createdCarResponseFromCar(createdCar);
        return response;
    }

    @Override
    public List<GetListCarResponse> findByModelYearGreaterThanEqual(int modelYear) {
        List<Car> cars = carRepository.findByModelYearGreaterThanEqual(modelYear);
        List<GetListCarResponse> responses = cars.stream()
                .map(car -> CarMapper.INSTANCE.getListCarResponseFromCar(car)).
                collect(Collectors.toList());
        return responses;    }

    @Override
    public List<GetListCarResponse> findByPlateContainingIgnoreCase(String partialPlate) {
        List<Car> cars = carRepository.findByPlateContainingIgnoreCase(partialPlate);
        List<GetListCarResponse> responses = cars.stream()
                .map(car -> CarMapper.INSTANCE.getListCarResponseFromCar(car)).
                collect(Collectors.toList());
        return responses;
    }
}
