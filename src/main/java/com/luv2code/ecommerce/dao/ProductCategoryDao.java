package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.dto.ProductCategoryDto;
import com.luv2code.ecommerce.repository.ProductCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCategoryDao {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ModelMapper modelMapper;
    public List<ProductCategoryDto> getProductCategories() {
        return productCategoryRepository.findAll().stream()
                .map(productCategory -> modelMapper.map(productCategory,ProductCategoryDto.class))
                .collect(Collectors.toList());
    }
}
