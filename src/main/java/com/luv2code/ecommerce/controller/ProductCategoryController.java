package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.CommonUtil.ResponseResource;
import com.luv2code.ecommerce.dto.ProductCategoryDto;
import com.luv2code.ecommerce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;
    @GetMapping("/productCategory")
    public ResponseEntity<ResponseResource<List<ProductCategoryDto>>> getProductCategory(){
        try {
            List<ProductCategoryDto> productCategories = productCategoryService.getProductCategories();
            ResponseResource<List<ProductCategoryDto>> resource = new ResponseResource<>(productCategories);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(), ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }

    }
}
