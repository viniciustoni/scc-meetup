package com.vagai.salesorder.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateStockDto {

    private Long productId;
    private BigDecimal qtdTotal;
    private BigDecimal qtdReserved;
    private BigDecimal qtdSold;
}
