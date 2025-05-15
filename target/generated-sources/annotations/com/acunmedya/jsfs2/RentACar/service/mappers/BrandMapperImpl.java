package com.acunmedya.jsfs2.RentACar.service.mappers;

import com.acunmedya.jsfs2.RentACar.entitiy.Brand;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.CreatedBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.DeletedBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.GetListBrandResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-11T13:00:21+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand brandFromCreateBrandRequest(CreateBrandRequest createBrandRequest) {
        if ( createBrandRequest == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setName( createBrandRequest.getName() );

        return brand;
    }

    @Override
    public CreatedBrandResponse createdBrandResponseFromBrand(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();

        createdBrandResponse.setId( brand.getId() );
        createdBrandResponse.setName( brand.getName() );

        return createdBrandResponse;
    }

    @Override
    public GetListBrandResponse getListBrandResponseFromBrand(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        GetListBrandResponse getListBrandResponse = new GetListBrandResponse();

        getListBrandResponse.setId( brand.getId() );
        getListBrandResponse.setName( brand.getName() );

        return getListBrandResponse;
    }

    @Override
    public DeletedBrandResponse deletedBrandResponseFromBrand(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        DeletedBrandResponse deletedBrandResponse = new DeletedBrandResponse();

        deletedBrandResponse.setId( brand.getId() );

        return deletedBrandResponse;
    }
}
