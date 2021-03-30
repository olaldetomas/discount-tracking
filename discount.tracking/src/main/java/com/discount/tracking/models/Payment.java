package com.discount.tracking.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Payment {
    public long id;
    public String reason;
    public String currency_id;
    public double coupon_amount;
    public String payment_type;
    public double transaction_amount;
    public double total_paid_amount;
    public String marketplace;
    public Date date_created;
    public Date date_approved;
    public Date last_modified;

    public Payment() {
    }
}