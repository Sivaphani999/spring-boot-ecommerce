package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.CheckoutDao;
import com.luv2code.ecommerce.dto.PaymentInfo;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckOutService {

    @Autowired
    private CheckoutDao checkoutDao;

    public CheckOutService(@Value("${stripe.key.secret}") String secretKey) {
        Stripe.apiKey = secretKey;
    }


    public PurchaseResponse placeOrder(Purchase purchase){
        return checkoutDao.placeOrder(purchase);
    }

    public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException{
        List<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentInfo.getAmount());
        params.put("currency", paymentInfo.getCurrency());
        params.put("payment_method_types", paymentMethodTypes);
        params.put("description","Luv2Shop Purchase");
        params.put("receipt_email",paymentInfo.getReceiptEmail());

        return PaymentIntent.create(params);
    }
}
