package com.example.serviceinventory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Inventory {
    private String idProduct;
    private Integer stock;

}
