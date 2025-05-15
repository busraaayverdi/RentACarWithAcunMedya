package com.acunmedya.jsfs2.RentACar.service.abstracts;

import com.acunmedya.jsfs2.RentACar.service.dtos.requests.model.CreateModelRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.CreatedModelResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.model.GetListModelResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ModelService {
    CreatedModelResponse add(CreateModelRequest request);
    List<GetListModelResponse> getList();
    List<GetListModelResponse> getByBrandName(String brandName);
    List<GetListModelResponse> getByBrandId(int brandId);
}
