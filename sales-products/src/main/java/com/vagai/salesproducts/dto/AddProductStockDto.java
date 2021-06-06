package com.vagai.salesproducts.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductStockDto {

    private Long productId;
    private BigDecimal qtdAdded;
}
