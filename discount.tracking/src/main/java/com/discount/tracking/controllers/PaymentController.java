package com.discount.tracking.controllers;

import com.discount.tracking.services.PaymentServiceImpl;
import com.discount.tracking.dtos.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Autowired
    PaymentServiceImpl service;

    @GetMapping
    public ResponseEntity<ArrayList<PaymentDto>> getPayments() {
        return new ResponseEntity<>(this.service.getPayments(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-period")
    public ResponseEntity<ArrayList<PaymentDto>> getPaymentsByPeriod(@RequestParam int period) {
        return new ResponseEntity<>(this.service.getPaymentsByPeriod(period), HttpStatus.OK);
    }

    @GetMapping(value = "/total-discount")
    public ResponseEntity<Integer> getTotalDiscount() {
        double totalDisconut = 0.0;
        for (PaymentDto payment : this.service.getPayments()) {
            totalDisconut += payment.coupon_amount;
        }
        return new ResponseEntity<>((int) totalDisconut, HttpStatus.OK);
    }


}