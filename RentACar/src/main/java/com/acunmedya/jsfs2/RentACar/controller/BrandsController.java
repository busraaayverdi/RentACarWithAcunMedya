package com.acunmedya.jsfs2.RentACar.controller;

import com.acunmedya.jsfs2.RentACar.entitiy.Brand;
import com.acunmedya.jsfs2.RentACar.repository.BrandRepository;
import com.acunmedya.jsfs2.RentACar.service.abstracts.BrandService;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand.UpdateBrandRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.CreatedBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.GetBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.GetListBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.UpdatedBrandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //api sınıfı olması için işaretle
@RequestMapping("/api/brands")
public class BrandsController {

    private final BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    //get
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListBrandResponse> getBrands(){
        return brandService.getAll();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public GetBrandResponse getByName(@PathVariable String name){
        return brandService.getByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public CreatedBrandResponse add(@RequestBody CreateBrandRequest request){
        return brandService.add(request);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedBrandResponse updatedBrandResponse(@RequestBody UpdateBrandRequest request){
        return brandService.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable int id){
        brandService.delete(id);
    }
}
