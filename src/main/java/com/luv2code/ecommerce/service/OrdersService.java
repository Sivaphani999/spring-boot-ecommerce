package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.OrdersDao;
import com.luv2code.ecommerce.dto.OrdersDTO;
import com.luv2code.ecommerce.entity.Orders;
import com.luv2code.ecommerce.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersDao ordersDao;

    public List<OrdersDTO> findByCustomerEmail(String email, int page, int size) {
        return ordersDao.findByCustomerEmail(email, page, size);
    }
}
