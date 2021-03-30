package com.discount.tracking.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PagingDto {
    int limit;
    int total;
    int offset;

    public PagingDto() {
    }
}