package com.luv2code.ecommerce.repository;

import com.luv2code.ecommerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;
import java.util.List;

public interface StateRepository extends JpaRepository<State, Integer> {

    List<State> findByCountryId(int id);

    List<State> findByCountryCode(String countryCode);
}