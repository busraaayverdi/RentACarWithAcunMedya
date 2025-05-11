package com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand;

public class GetListBrandRequest {private int id;
    private String name;

    public GetListBrandRequest(){

    }

    public GetListBrandRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
