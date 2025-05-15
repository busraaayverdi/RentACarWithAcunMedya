package com.acunmedya.jsfs2.RentACar.repository;


import com.acunmedya.jsfs2.RentACar.entitiy.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
//    List<Model> findByBrandName(String brandName);

    @Query("Select m From Model m Where m.brand.name = :brandName") //jpql (entity) bazlı query
    List<Model> findByBrandName(@Param("brandName") String brandName);

    @Query(value = "select * from models where brand_id=:brandId",nativeQuery = true) //native query olduğunu belirttik
    List<Model> findByBrandIdNative(@Param("brandId") int brandId);
}
