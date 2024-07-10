package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.dto.OrdersDTO;
import com.luv2code.ecommerce.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Page<Orders> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);
}