package com.vagai.salesorder.mapper;


import com.vagai.salesorder.dto.order.PurchaseOrderDto;
import com.vagai.salesorder.entity.PurchaseOrder;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface PurchaseOrderMapper {

    PurchaseOrderDto mapToPurchaseOrderDto(PurchaseOrder purchaseOrder);

    PurchaseOrder mapToPurchaseOrder(PurchaseOrderDto purchaseOrderDto);

}
