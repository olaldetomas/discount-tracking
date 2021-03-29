package com.discount.tracking.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Paging {
    int limit;
    int offset;
    int total;
}
