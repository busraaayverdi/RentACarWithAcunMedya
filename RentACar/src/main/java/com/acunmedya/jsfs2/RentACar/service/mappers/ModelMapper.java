package com.acunmedya.jsfs2.RentACar.service.mappers;

import com.acunmedya.jsfs2.RentACar.entitiy.Model;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.CreatedBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.GetListModelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(source = "brandId",target = "brand.id")
    Model modelFromCreateModelRequest(CreateModelRequest createModelRequest);

    @Mapping(target = "brandId", source = "brand.id" )
    CreatedModelResponse createdModelResponseFromModel(Model model);

    @Mapping(target = "brandId", source = "brand.id" )
    @Mapping(target = "brandName", source = "brand.name" )

    GetListModelResponse getListModelResponseFromModel(Model model);
}
