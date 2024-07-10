package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ProductCategoryDao;
import com.luv2code.ecommerce.dto.ProductCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryDao productCategoryDao;
    public List<ProductCategoryDto> getProductCategories(){
        return  productCategoryDao.getProductCategories();
    }
}
