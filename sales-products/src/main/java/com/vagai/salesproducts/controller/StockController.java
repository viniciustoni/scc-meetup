package com.vagai.salesproducts.controller;

import com.vagai.salesproducts.dto.AddProductStockDto;
import com.vagai.salesproducts.dto.ProductDto;
import com.vagai.salesproducts.dto.ReserveProductDto;
import com.vagai.salesproducts.dto.UpdateSoldStockDto;
import com.vagai.salesproducts.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vagai.salesproducts.controller.ProductDefinition.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = STOCK_ENDPOINT, produces = APPLICATION_JSON_VALUE)
public class StockController {

    private final StockService stockService;

    @PostMapping(value = RESERVE_STOCK_ENDPOINT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> reserveProduct(final ReserveProductDto reserveProductDto) {
        return ResponseEntity.ok(stockService.reserveProduct(reserveProductDto));
    }

    @PostMapping(value = SOLD_STOCK_ENDPOINT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateSoldStock(final UpdateSoldStockDto updateSoldStockDto) {
        return ResponseEntity.ok(stockService.updateSoldStock(updateSoldStockDto));
    }

    @PostMapping(value = ADD_STOCK_ENDPOINT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> addProductsToStock(final AddProductStockDto addProductStockDto) {
        return ResponseEntity.ok(stockService.addProductStock(addProductStockDto));
    }
}
