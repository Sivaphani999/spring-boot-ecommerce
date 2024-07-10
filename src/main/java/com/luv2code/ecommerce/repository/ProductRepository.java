package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    String FIND_BY_NAME = """
            SELECT * FROM product WHERE name LIKE (:name);
            """;
    @Query(value = FIND_BY_NAME, nativeQuery = true)
    Page<Product> findProductBySearchTerm(@Param("name") String name, Pageable pageable);
}
