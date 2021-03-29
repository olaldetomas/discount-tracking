package com.discount.tracking.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponsePayment {
    public Paging paging;
    public ArrayList<Payment> results;
}
