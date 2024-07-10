package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.entity.Customer;
import com.luv2code.ecommerce.entity.OrderItem;
import com.luv2code.ecommerce.entity.Orders;
import com.luv2code.ecommerce.repository.CustomerRepository;
import com.luv2code.ecommerce.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PushbackReader;
import java.util.Set;
import java.util.UUID;

@Component
public class CheckoutDao {

    @Autowired
    private CustomerRepository customerRepository;
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase){
        Orders order = new Orders();
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        order.setTotalPrice(purchase.getOrder().getTotalPrice());
        order.setTotalQuantity(purchase.getOrder().getTotalQuantity());
        Customer customer = purchase.getCustomer();

        Customer customerDataFromDb = customerRepository.findByEmail(customer.getEmail());
        if(customerDataFromDb != null){
            customer =  customerDataFromDb;
        }

        customer.add(order);
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber(){
        return UUID.randomUUID().toString();
    }
}
