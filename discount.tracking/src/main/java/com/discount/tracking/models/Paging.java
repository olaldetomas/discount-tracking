package com.discount.tracking.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Paging {
    int limit;
    int total;
    int offset;

    public Paging() {
    }
}
