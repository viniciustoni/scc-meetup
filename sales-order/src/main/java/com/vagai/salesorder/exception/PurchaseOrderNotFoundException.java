package com.vagai.salesorder.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND)
public class PurchaseOrderNotFoundException extends RuntimeException {
    public PurchaseOrderNotFoundException(final Long purchaseOrder) {
        super(String.format("Purchase order id [%s] not found.", purchaseOrder));
    }
}
