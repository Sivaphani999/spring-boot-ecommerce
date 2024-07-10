package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.CommonUtil.ResponseResource;
import com.luv2code.ecommerce.dto.OrdersDTO;
import com.luv2code.ecommerce.entity.Orders;
import com.luv2code.ecommerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping("/search/findByCustomerEmail")
    public ResponseEntity<ResponseResource<List<OrdersDTO>>> findByCustomerEmail(@RequestParam("email") String email, @RequestParam(value = "page", defaultValue = "0") int page,
                                                                        @RequestParam(value = "size", defaultValue = "10") int size){
        try{
            List<OrdersDTO> orders = ordersService.findByCustomerEmail(email, page, size);
            ResponseResource<List<OrdersDTO>> resource = new ResponseResource<>(ResponseResource.R_MSG_EMPTY,ResponseResource.R_CODE_OK, orders);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource<List<OrdersDTO>> resource = new ResponseResource<>(e.getMessage(), ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }
}
