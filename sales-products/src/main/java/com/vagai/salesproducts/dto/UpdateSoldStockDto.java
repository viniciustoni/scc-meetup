package com.vagai.salesproducts.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateSoldStockDto {

    private Long productId;
    private BigDecimal qtdSold;
}
