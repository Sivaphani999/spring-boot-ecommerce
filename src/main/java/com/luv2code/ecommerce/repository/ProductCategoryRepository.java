package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
