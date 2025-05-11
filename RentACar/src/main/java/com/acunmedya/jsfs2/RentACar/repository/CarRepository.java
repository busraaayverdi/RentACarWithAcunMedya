package com.acunmedya.jsfs2.RentACar.repository;

import com.acunmedya.jsfs2.RentACar.entitiy.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    //model yılı belirli bir yıldan büyük veya eşit olanarabaları getir
    List<Car> findByModelYearGreaterThanEqual(int modelYear);

    //Plaka içinde geçen ifadeye göre araçları getir
    List <Car> findByPlateContainingIgnoreCase(String partialPlate);
}
