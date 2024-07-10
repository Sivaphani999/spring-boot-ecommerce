package com.luv2code.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.luv2code.ecommerce.entity.Address;
import com.luv2code.ecommerce.entity.Customer;
import com.luv2code.ecommerce.entity.OrderItem;
import com.luv2code.ecommerce.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Purchase {
    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Orders order;

    private Set<OrderItem> orderItems;

}
