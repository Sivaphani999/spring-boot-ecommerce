package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.dto.OrdersDTO;
import com.luv2code.ecommerce.entity.Customer;
import com.luv2code.ecommerce.entity.Orders;
import com.luv2code.ecommerce.repository.CustomerRepository;
import com.luv2code.ecommerce.repository.OrdersRepository;
import jakarta.persistence.criteria.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdersDao {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ModelMapper modelMapper;


    public List<OrdersDTO> findByCustomerEmail(String email, int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        List<Orders> orders = ordersRepository.findByCustomerEmailOrderByDateCreatedDesc(email, pageable).stream().toList();
        return  orders.stream().map(order -> modelMapper.map(order, OrdersDTO.class)).collect(Collectors.toList());
    }
}
