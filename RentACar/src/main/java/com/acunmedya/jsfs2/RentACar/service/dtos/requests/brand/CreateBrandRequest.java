package com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand;

public class CreateBrandRequest {

    private String name;

    public CreateBrandRequest() {
    }

    public CreateBrandRequest( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
