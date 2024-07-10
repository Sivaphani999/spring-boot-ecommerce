package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address, Long> {

}