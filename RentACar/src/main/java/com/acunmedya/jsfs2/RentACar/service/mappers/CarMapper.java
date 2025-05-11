package com.acunmedya.jsfs2.RentACar.service.mappers;

import com.acunmedya.jsfs2.RentACar.entitiy.Car;
import com.acunmedya.jsfs2.RentACar.entitiy.Model;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.GetListCarResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.GetListModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "modelId",target = "model.id")
    Car carFromCreateCarRequest(CreateCarRequest createCarRequest);

    @Mapping(target = "modelId", source = "model.id" )
    CreatedCarResponse createdCarResponseFromCar(Car car);

    @Mapping(target = "modelId", source = "model.id" )
    @Mapping(target = "modelName", source = "model.name" )
    GetListCarResponse getListCarResponseFromCar(Car car);
}
