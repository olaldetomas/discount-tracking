package com.discount.tracking.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IdentificationTypesResponse {
    public String id;
    public String name;
    public String type;
    public int min_length;

    public IdentificationTypesResponse() {
    }
}
