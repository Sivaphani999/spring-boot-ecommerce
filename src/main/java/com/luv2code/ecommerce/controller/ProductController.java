package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.CommonUtil.ResponseResource;
import com.luv2code.ecommerce.dto.PaginatedProductsDto;
import com.luv2code.ecommerce.dto.ProductDto;
import com.luv2code.ecommerce.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping(value = "/products")
    public ResponseEntity<ResponseResource<List<ProductDto>>> getProducts(){
        try{
            List<ProductDto> productDto = productService.getAllProducts();
            ResponseResource<List<ProductDto>> resource = new ResponseResource<>(productDto);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(), ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }
    @GetMapping(value = "/products/{id}")
    public
    ResponseEntity<ResponseResource<PaginatedProductsDto>> getProduct(@PathVariable Long id, @RequestParam(defaultValue = "0") int pageNumber,
                                                                      @RequestParam(defaultValue = "10") int pageSize){
        try{
            PaginatedProductsDto productDto = productService.getProduct(id, pageNumber, pageSize);
            ResponseResource<PaginatedProductsDto> resource = new ResponseResource<>(productDto);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(), ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }

    @GetMapping(value = "/product/{id}")
    public
    ResponseEntity<ResponseResource<ProductDto>> getProduct(@PathVariable Long id){
        try{
            ProductDto productDto = productService.getProduct(id);
            ResponseResource<ProductDto> resource = new ResponseResource<>(productDto);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(), ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }

    @GetMapping(value = "/search/products")
    public ResponseEntity<ResponseResource<PaginatedProductsDto>> getProductBySerachTerm(@RequestParam("name") String name, @RequestParam(defaultValue = "0") int pageNumber,
                                                        @RequestParam(defaultValue = "10") int pageSize) {
        try{
            PaginatedProductsDto productDto = productService.getProductBySearchTerm(name, pageNumber, pageSize);
            ResponseResource<PaginatedProductsDto> resource = new ResponseResource<>(productDto);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource<PaginatedProductsDto> resource = new ResponseResource<>(e.getMessage(),ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }
}
