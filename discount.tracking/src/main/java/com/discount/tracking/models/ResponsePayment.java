package com.discount.tracking.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponsePayment {
    public Paging paging;
    public ArrayList<PaymentItem> results;

    public ResponsePayment() {
    }
}
