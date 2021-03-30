package com.discount.tracking.services;

import com.discount.tracking.dtos.PaymentDto;

import java.util.ArrayList;

public interface PaymentService {
    ArrayList<PaymentDto> getPayments();
    ArrayList<PaymentDto>  getPaymentsByPeriod(int period);
}
