package com.acunmedya.jsfs2.RentACar.service.dtos.requests.brand;

public class DeleteBrandRequest {
    private int id;
    private String name;

    public DeleteBrandRequest(){

    }

    public DeleteBrandRequest(int id, String name) {
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
