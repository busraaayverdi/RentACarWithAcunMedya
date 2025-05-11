package com.acunmedya.jsfs2.RentACar.service.abstracts;

import com.acunmedya.jsfs2.RentACar.service.dtos.requests.car.CreateCarRequest;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.CreatedCarResponse;
import com.acunmedya.jsfs2.RentACar.service.dtos.responses.car.GetListCarResponse;

import java.util.List;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest request);
    List<GetListCarResponse> findByModelYearGreaterThanEqual(int modelYear);
    List<GetListCarResponse> findByPlateContainingIgnoreCase(String partialPlate);
}
