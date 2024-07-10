package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.CommonUtil.ResponseResource;
import com.luv2code.ecommerce.dto.PaymentInfo;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.service.CheckOutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckOutService  checkOutService;

    @PostMapping("/purchase")
    public ResponseEntity<ResponseResource<PurchaseResponse>> placeOrder(@RequestBody Purchase purchase){
        try{
            PurchaseResponse response = checkOutService.placeOrder(purchase);
            ResponseResource<PurchaseResponse> resource = new ResponseResource<>( ResponseResource.R_MSG_EMPTY ,ResponseResource.R_CODE_OK, response);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource<PurchaseResponse> resource = new ResponseResource<>(ResponseResource.R_MSG_EMPTY, ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }

    @PostMapping("/payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException{
        PaymentIntent paymentIntent = checkOutService.createPaymentIntent(paymentInfo);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}
