package com.acunmedya.jsfs2.RentACar.service.rules;

import com.acunmedya.jsfs2.RentACar.common.entity.exceptions.types.BusinessException;
import com.acunmedya.jsfs2.RentACar.entitiy.Brand;
import com.acunmedya.jsfs2.RentACar.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandBusinessRules {
    private final BrandRepository brandRepository;

    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void checkIfBrandNameExists(String name){
        Brand brand = brandRepository.getByNameIgnoreCase(name).get();
        if(brand!=null)
            throw new BusinessException("Brand name already exist");
    }
}
