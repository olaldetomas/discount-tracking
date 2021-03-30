package com.discount.tracking.Controllers;

import com.discount.tracking.Services.PaymentService;
import com.discount.tracking.models.Payment;
import com.discount.tracking.models.PaymentItem;
import com.discount.tracking.models.ResponsePayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<ResponsePayment> getPayments() {
        ResponsePayment result = paymentService.getPaymentsFromMercadoPago();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/discount")
    public ResponseEntity<Double> getDiscount() {
        double totalDisconut = 0.0;
        ResponsePayment responsePayment = paymentService.getPaymentsFromMercadoPago();

        for(PaymentItem paymentItem : responsePayment.results){
            Payment payment = paymentItem.payment;
            totalDisconut += payment.coupon_amount;
        }

        return new ResponseEntity<>(totalDisconut, HttpStatus.OK);
    }

}
