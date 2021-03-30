package com.discount.tracking.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponsePaymentDto {
    public PagingDto paging;
    public ArrayList<PaymentItemDto> results;

    public ResponsePaymentDto() {
    }
}
