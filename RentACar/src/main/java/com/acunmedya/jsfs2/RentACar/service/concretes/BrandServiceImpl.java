package com.acunmedya.jsfs2.RentACar.service.concretes;

import com.acunmedya.jsfs2.RentACar.entitiy.Brand;
import com.acunmedya.jsfs2.RentACar.repository.BrandRepository;
import com.acunmedya.jsfs2.RentACar.service.abstracts.BrandService;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand.UpdateBrandRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.CreatedBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.GetBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.GetListBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.UpdatedBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.mappers.BrandMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public CreatedBrandResponse add(CreateBrandRequest request) {
//        Brand brand = new Brand();
//        brand.setName(request.getName());
//        Brand createdBrand = brandRepository.save(brand);
//
//        CreatedBrandResponse response = new CreatedBrandResponse();
//        response.setId(createdBrand.getId());
//        response.setName(createdBrand.getName());
//        return response;

        Brand brand = BrandMapper.INSTANCE.brandFromCreateBrandRequest(request);
        Brand createdBrand = brandRepository.save(brand);
        CreatedBrandResponse response = BrandMapper.INSTANCE.createdBrandResponseFromBrand(createdBrand);
        return response;
    }

    @Override
    public List<GetListBrandResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<GetListBrandResponse> responses = brands.stream()
                .map(BrandMapper.INSTANCE::getListBrandResponseFromBrand).collect(Collectors.toList());

        return responses;
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = brandRepository.
                findById(updateBrandRequest.getId()).orElseThrow(()-> new RuntimeException("Brand not found"));
        brand.setName(updateBrandRequest.getName());
        Brand updatedBrand = brandRepository.save(brand);
        UpdatedBrandResponse response = new UpdatedBrandResponse();
        response.setId(updatedBrand.getId());
        response.setName(updatedBrand.getName());
        return response;
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public GetBrandResponse getByName(String name) {
        Brand brand= brandRepository.getByName(name).orElseThrow(()-> new RuntimeException("Brand not foung"));
        return mapToBrandResponse(brand);
    }

//    private GetListBrandResponse mapToResponse(Brand brand){
//        GetListBrandResponse response= new GetListBrandResponse();
//        response.setId(brand.getId());
//        response.setName(brand.getName());
//        return response;
//    }

    private GetBrandResponse mapToBrandResponse(Brand brand){
        GetBrandResponse response= new GetBrandResponse();
        response.setId(brand.getId());
        response.setName(brand.getName());
        return response;
    }
}
