package com.acunmedya.jsfs2.RentACar.service.abstracts;

import com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand.CreateBrandRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand.UpdateBrandRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.CreatedBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.GetBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.GetListBrandResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.brand.UpdatedBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest request);
    List<GetListBrandResponse> getAll();
    UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
    GetBrandResponse getByName(String name);


}
