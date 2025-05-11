package com.acunmedya.jsfs2.RentACar.service.mappers;

import com.acunmedya.jsfs2.RentACar.entitiy.Brand;
import com.acunmedya.jsfs2.RentACar.entitiy.Model;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.GetListModelResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-10T11:52:11+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
public class ModelMapperImpl implements ModelMapper {

    @Override
    public Model modelFromCreateModelRequest(CreateModelRequest createModelRequest) {
        if ( createModelRequest == null ) {
            return null;
        }

        Model model = new Model();

        model.setBrand( createModelRequestToBrand( createModelRequest ) );
        model.setName( createModelRequest.name() );

        return model;
    }

    @Override
    public CreatedModelResponse createdModelResponseFromModel(Model model) {
        if ( model == null ) {
            return null;
        }

        int brandId = 0;
        int id = 0;
        String name = null;

        brandId = modelBrandId( model );
        id = model.getId();
        name = model.getName();

        CreatedModelResponse createdModelResponse = new CreatedModelResponse( id, name, brandId );

        return createdModelResponse;
    }

    @Override
    public GetListModelResponse getListModelResponseFromModel(Model model) {
        if ( model == null ) {
            return null;
        }

        int brandId = 0;
        String brandName = null;
        int id = 0;
        String name = null;

        brandId = modelBrandId( model );
        brandName = modelBrandName( model );
        id = model.getId();
        name = model.getName();

        GetListModelResponse getListModelResponse = new GetListModelResponse( id, name, brandId, brandName );

        return getListModelResponse;
    }

    protected Brand createModelRequestToBrand(CreateModelRequest createModelRequest) {
        if ( createModelRequest == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( createModelRequest.brandId() );

        return brand;
    }

    private int modelBrandId(Model model) {
        if ( model == null ) {
            return 0;
        }
        Brand brand = model.getBrand();
        if ( brand == null ) {
            return 0;
        }
        int id = brand.getId();
        return id;
    }

    private String modelBrandName(Model model) {
        if ( model == null ) {
            return null;
        }
        Brand brand = model.getBrand();
        if ( brand == null ) {
            return null;
        }
        String name = brand.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
