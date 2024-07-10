package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.CountryDao;
import com.luv2code.ecommerce.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryDao countryDao;
    public List<CountryDTO> getCountry() {
        return countryDao.getCountry();
    }

    public List<CountryDTO> getCountryById(int id) {
        return countryDao.getCountryById(id);
    }
}
