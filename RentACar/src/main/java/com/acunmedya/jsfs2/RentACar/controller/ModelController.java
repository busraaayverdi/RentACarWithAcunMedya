package com.acunmedya.jsfs2.RentACar.controller;


import com.acunmedya.jsfs2.RentACar.service.abstracts.ModelService;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.GetListModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(CreateModelRequest request){
        return modelService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetListModelResponse> getList(){
        return modelService.getList();
    }

    @GetMapping("/{brandName}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListModelResponse> getByBrandName(@PathVariable String brandName){
        return modelService.getByBrandName(brandName);
    }
    @GetMapping("getbybrandid/{brandId}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetListModelResponse> getByBrandId(@PathVariable int brandId){
        return modelService.getByBrandId(brandId);
    }

}
