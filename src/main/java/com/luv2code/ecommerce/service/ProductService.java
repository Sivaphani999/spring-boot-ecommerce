package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ProductDao;
import com.luv2code.ecommerce.dto.PaginatedProductsDto;
import com.luv2code.ecommerce.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<ProductDto> getAllProducts(){

        return productDao.fetchProducts();
    }

    public PaginatedProductsDto getProduct(Long id, int pageNumber, int pageSize) {
        return productDao.getProduct(id, pageNumber, pageSize);
    }

    public ProductDto getProduct(Long id) {
        return productDao.getProduct(id);
    }


    public PaginatedProductsDto getProductBySearchTerm(String name, int pageNumber, int pageSize) {
        return productDao.getProductBySearchTerm(name, pageNumber, pageSize);
    }
}
