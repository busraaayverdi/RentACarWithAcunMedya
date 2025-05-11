package com.acunmedya.jsfs2.RentACar.repository;


import com.acunmedya.jsfs2.RentACar.entitiy.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
    List<Model> findByBrandName(String brandName);
}
