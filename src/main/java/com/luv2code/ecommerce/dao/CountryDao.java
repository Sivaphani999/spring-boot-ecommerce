package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.dto.CountryDTO;
import com.luv2code.ecommerce.entity.Country;
import com.luv2code.ecommerce.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryDao {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ModelMapper modelMapper;
    public List<CountryDTO> getCountry() {
        return countryRepository.findAll().stream().map(val -> modelMapper.map(val, CountryDTO.class)).collect(Collectors.toList());
    }

    public List<CountryDTO> getCountryById(int id) {
        return countryRepository.findById(id).stream().map(val -> modelMapper.map(val, CountryDTO.class)).collect(Collectors.toList());
    }
}
