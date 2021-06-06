package com.vagai.salesproducts.dto;

import com.vagai.salesproducts.entity.enumerated.UnitOfMeasure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class ProductDto {

    private Long productId;
    private String name;
    private BigDecimal unitPrice;
    private UnitOfMeasure unitOfMeasure;
    private BigDecimal qtdTotal;
    private BigDecimal qtdAvailable;
    private BigDecimal qtdReserved;
    private BigDecimal qtdSold;
}
