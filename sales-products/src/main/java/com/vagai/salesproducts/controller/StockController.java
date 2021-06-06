package com.vagai.salesproducts.controller;

import com.vagai.salesproducts.dto.AddProductStockDto;
import com.vagai.salesproducts.dto.ProductDto;
import com.vagai.salesproducts.dto.ReserveProductDto;
import com.vagai.salesproducts.dto.UpdateSoldStockDto;
import com.vagai.salesproducts.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vagai.salesproducts.controller.ProductDefinition.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = STOCK_ENDPOINT, produces = APPLICATION_JSON_VALUE)
public class StockController {

    private final StockService stockService;

    public StockController(final StockService stockService) {
        this.stockService = stockService;
    }

    @PutMapping(value = RESERVE_STOCK_ENDPOINT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> reserveProduct(final ReserveProductDto reserveProductDto) {
        return ResponseEntity.ok(stockService.reserveProduct(reserveProductDto));
    }

    @PutMapping(value = SOLD_STOCK_ENDPOINT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> updateSoldStock(final UpdateSoldStockDto updateSoldStockDto) {
        return ResponseEntity.ok(stockService.updateSoldStock(updateSoldStockDto));
    }

    @PutMapping(value = ADD_STOCK_ENDPOINT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> addProductsToStock(final AddProductStockDto addProductStockDto) {
        return ResponseEntity.ok(stockService.addProductStock(addProductStockDto));
    }
}
