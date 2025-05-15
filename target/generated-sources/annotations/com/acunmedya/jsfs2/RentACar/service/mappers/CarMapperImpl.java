package com.acunmedya.jsfs2.RentACar.service.mappers;

import com.acunmedya.jsfs2.RentACar.entitiy.Car;
import com.acunmedya.jsfs2.RentACar.entitiy.Model;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.GetListCarResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T10:54:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public Car carFromCreateCarRequest(CreateCarRequest createCarRequest) {
        if ( createCarRequest == null ) {
            return null;
        }

        Car car = new Car();

        car.setModel( createCarRequestToModel( createCarRequest ) );
        car.setModelYear( createCarRequest.modelYear() );
        car.setPlate( createCarRequest.plate() );
        car.setDailyPrice( createCarRequest.dailyPrice() );
        car.setKilometer( createCarRequest.kilometer() );

        return car;
    }

    @Override
    public CreatedCarResponse createdCarResponseFromCar(Car car) {
        if ( car == null ) {
            return null;
        }

        int modelId = 0;
        int id = 0;
        int modelYear = 0;
        String plate = null;
        double dailyPrice = 0.0d;
        int kilometer = 0;

        modelId = carModelId( car );
        id = car.getId();
        modelYear = car.getModelYear();
        plate = car.getPlate();
        dailyPrice = car.getDailyPrice();
        kilometer = car.getKilometer();

        CreatedCarResponse createdCarResponse = new CreatedCarResponse( id, modelId, modelYear, plate, dailyPrice, kilometer );

        return createdCarResponse;
    }

    @Override
    public GetListCarResponse getListCarResponseFromCar(Car car) {
        if ( car == null ) {
            return null;
        }

        int modelId = 0;
        String modelName = null;
        int id = 0;
        int modelYear = 0;
        String plate = null;
        double dailyPrice = 0.0d;
        int kilometer = 0;

        modelId = carModelId( car );
        modelName = carModelName( car );
        id = car.getId();
        modelYear = car.getModelYear();
        plate = car.getPlate();
        dailyPrice = car.getDailyPrice();
        kilometer = car.getKilometer();

        GetListCarResponse getListCarResponse = new GetListCarResponse( id, modelId, modelYear, modelName, plate, dailyPrice, kilometer );

        return getListCarResponse;
    }

    protected Model createCarRequestToModel(CreateCarRequest createCarRequest) {
        if ( createCarRequest == null ) {
            return null;
        }

        Model model = new Model();

        model.setId( createCarRequest.modelId() );

        return model;
    }

    private int carModelId(Car car) {
        if ( car == null ) {
            return 0;
        }
        Model model = car.getModel();
        if ( model == null ) {
            return 0;
        }
        int id = model.getId();
        return id;
    }

    private String carModelName(Car car) {
        if ( car == null ) {
            return null;
        }
        Model model = car.getModel();
        if ( model == null ) {
            return null;
        }
        String name = model.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
