package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.dto.PaginatedProductsDto;
import com.luv2code.ecommerce.dto.ProductDto;
import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;


@Component
@Slf4j
public class ProductDao {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;
    public List<ProductDto> fetchProducts(){
        List<Product> products = productRepository.findAll();
        return products.parallelStream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
    }

    public PaginatedProductsDto getProduct(Long id, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> products = productRepository.findByCategoryId(id, pageable);
        PaginatedProductsDto paginatedProductsDto = new PaginatedProductsDto();
        paginatedProductsDto.setProductDtoList(products.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList()));
        paginatedProductsDto.setPageSize(products.getSize());
        paginatedProductsDto.setPageNumber(products.getNumber());
        paginatedProductsDto.setTotalElements(products.getTotalElements());
        return paginatedProductsDto;
    }

    public ProductDto getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        ProductDto productDto = modelMapper.map(product.get(), ProductDto.class);
        return productDto;
    }

    public PaginatedProductsDto getProductBySearchTerm(String name, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> products = productRepository.findProductBySearchTerm("%" + name +"%", pageable);
        PaginatedProductsDto paginatedProductsDto = new PaginatedProductsDto();
        paginatedProductsDto.setProductDtoList(products.stream().map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList()));
        paginatedProductsDto.setTotalElements(products.getTotalElements());
        paginatedProductsDto.setPageSize(products.getSize());
        paginatedProductsDto.setPageNumber(products.getNumber());
        return paginatedProductsDto;
    }
}
