package com.vagai.salesorder.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveProductDto {

    private Long productId;
    private BigDecimal qtdReserved;
}
