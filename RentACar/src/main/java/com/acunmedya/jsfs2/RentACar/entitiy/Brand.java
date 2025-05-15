package com.acunmedya.jsfs2.RentACar.entitiy;

import com.acunmedya.jsfs2.RentACar.common.entity.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity // db tablosu olduğunu temsil eder
@Table(name = "brands")
@SQLRestriction(value = "deleted_at IS NULL") //silinmiş verileri geri gösterme
public class Brand extends BaseEntity {

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {
    }

    @Id //primary key alanı
    @GeneratedValue(strategy = GenerationType.IDENTITY) //otomatik artan id
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private List<Model> models;

    public Brand(int id, String name, List<Model> models) {
        this.id = id;
        this.name = name;
        this.models = models;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
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
