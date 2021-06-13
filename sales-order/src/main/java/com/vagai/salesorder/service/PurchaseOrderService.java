package com.vagai.salesorder.service;

import com.vagai.salesorder.dto.order.PurchaseOrderDto;

import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrderDto createPurchaseOrder(PurchaseOrderDto purchaseOrderDto);

    PurchaseOrderDto paidPurchaseOrder(Long purchaseOrderId);

    List<PurchaseOrderDto> getPurchaseOrderByClientId(Long clientId);

    PurchaseOrderDto getPurchaseOrderById(Long purchaseOrderId);
}
