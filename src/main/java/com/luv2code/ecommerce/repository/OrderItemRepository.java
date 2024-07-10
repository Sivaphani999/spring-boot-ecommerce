package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}