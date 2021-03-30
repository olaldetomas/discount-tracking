package com.discount.tracking.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseIdentificationTypesDto {
    public String id;
    public String name;
    public String type;
    public int min_length;

    public ResponseIdentificationTypesDto() {
    }
}
