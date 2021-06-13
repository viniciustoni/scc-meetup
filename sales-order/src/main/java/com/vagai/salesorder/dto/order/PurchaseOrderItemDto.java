package com.vagai.salesorder.dto.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseOrderItemDto {

    private Long purchaseOrderItemId;
    private Long productId;
    private BigDecimal quantity;
    private BigDecimal priceItem;
    private BigDecimal totalPrice;

}
