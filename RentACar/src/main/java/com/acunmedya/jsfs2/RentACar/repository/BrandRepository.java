package com.acunmedya.jsfs2.RentACar.repository;

import com.acunmedya.jsfs2.RentACar.entitiy.Brand;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

    Optional<Brand> getByName(String name);

}
