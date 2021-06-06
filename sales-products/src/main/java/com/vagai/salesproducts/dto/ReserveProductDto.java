package com.vagai.salesproducts.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReserveProductDto {

    private Long productId;
    private BigDecimal qtdReserved;
}
