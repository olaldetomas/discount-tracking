package com.discount.tracking.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Payment {
    public int id;
    public String reason;
    public String currency_id;
    public double coupon_amount;
    public String payment_type;
}