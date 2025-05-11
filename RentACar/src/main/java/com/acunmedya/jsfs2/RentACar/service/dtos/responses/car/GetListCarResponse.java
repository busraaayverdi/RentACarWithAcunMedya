package com.acunmedya.jsfs2.RentACar.service.dtos.responses.car;

public record GetListCarResponse(int id,int modelId,int modelYear,String modelName,String plate,double dailyPrice,int kilometer) {
}
