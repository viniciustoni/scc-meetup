package com.vagai.salesorder.dto.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PurchaseOrderDto {

    private Long purchaseOrderId;
    private Long clientId;
    private BigDecimal totalAmount;
    private BigDecimal discount;
    private List<PurchaseOrderItemDto> purchaseOrderItems;

}
