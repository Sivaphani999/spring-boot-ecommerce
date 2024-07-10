package com.luv2code.ecommerce.dto;


import com.luv2code.ecommerce.entity.Address;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdersDTO {
    private Long id;

    private String orderTrackingNumber;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private Address billingAddressId;

    private Long customerId;

    private Address shippingAddressId;

    private String status;

    private Date dateCreated;

    private Date lastUpdated;

}
