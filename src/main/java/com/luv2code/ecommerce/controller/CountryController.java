package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.CommonUtil.ResponseResource;
import com.luv2code.ecommerce.dto.CountryDTO;
import com.luv2code.ecommerce.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping
    private ResponseEntity<ResponseResource<List<CountryDTO>>> getCountry(){
        try{
            List<CountryDTO> countryDTOList = countryService.getCountry();
            ResponseResource resource = new ResponseResource<>(countryDTOList);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(), ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseResource<List<CountryDTO>>> getCountryById(@PathVariable("id") int id){
        try {
            List<CountryDTO> countryDTOList = countryService.getCountryById(id);
            ResponseResource resource = new ResponseResource(countryDTOList);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(), ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }
}
