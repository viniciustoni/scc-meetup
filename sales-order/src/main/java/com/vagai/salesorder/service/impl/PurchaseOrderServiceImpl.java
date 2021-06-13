package com.vagai.salesorder.service.impl;

import com.vagai.salesorder.caller.StockProductCaller;
import com.vagai.salesorder.dto.order.PurchaseOrderDto;
import com.vagai.salesorder.dto.product.ReserveProductDto;
import com.vagai.salesorder.entity.PurchaseOrder;
import com.vagai.salesorder.entity.PurchaseOrderItem;
import com.vagai.salesorder.exception.PurchaseOrderNotFoundException;
import com.vagai.salesorder.mapper.PurchaseOrderMapper;
import com.vagai.salesorder.repository.PurchaseOrderRepository;
import com.vagai.salesorder.service.PurchaseOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;
    private final StockProductCaller stockProductCaller;

    @Override
    @Transactional
    public PurchaseOrderDto createPurchaseOrder(final PurchaseOrderDto purchaseOrderDto) {
        final PurchaseOrder purchaseOrder = purchaseOrderRepository.save(purchaseOrderMapper.mapToPurchaseOrder(purchaseOrderDto));

        purchaseOrder.getPurchaseOrderItems()
                .forEach(this::reserveProduct);

        return purchaseOrderMapper.mapToPurchaseOrderDto(purchaseOrder);
    }

    @Override
    public PurchaseOrderDto paidPurchaseOrder(final Long purchaseOrderId) {
        // TODO: include kafka test here
        return null;
    }

    @Override
    public List<PurchaseOrderDto> getPurchaseOrderByClientId(final Long clientId) {
        return purchaseOrderRepository.findByClientId(clientId)
                .stream()
                .map(purchaseOrderMapper::mapToPurchaseOrderDto)
                .collect(toList());
    }

    @Override
    public PurchaseOrderDto getPurchaseOrderById(final Long purchaseOrderId) {
        return purchaseOrderRepository.findById(purchaseOrderId)
                .map(purchaseOrderMapper::mapToPurchaseOrderDto)
                .orElseThrow(() -> new PurchaseOrderNotFoundException(purchaseOrderId));
    }

    private void reserveProduct(final PurchaseOrderItem purchaseOrderItem) {
        final ReserveProductDto reserveProductDto = new ReserveProductDto(purchaseOrderItem.getProductId(), purchaseOrderItem.getQuantity());
        stockProductCaller.reserveProductItem(reserveProductDto);
    }
}
