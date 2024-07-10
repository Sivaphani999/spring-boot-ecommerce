package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    Customer findByEmail(String theEmail);

}