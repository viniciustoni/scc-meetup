package com.vagai.salesorder.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long productId;
    private String name;
    private BigDecimal unitPrice;
    private String unitOfMeasure;
    private BigDecimal qtdTotal;
    private BigDecimal qtdAvailable;
    private BigDecimal qtdReserved;
    private BigDecimal qtdSold;
}
