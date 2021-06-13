package com.vagai.salesproducts.controller;

import com.vagai.salesproducts.dto.ProductDto;
import com.vagai.salesproducts.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.vagai.salesproducts.controller.ProductDefinition.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@RequestMapping(value = API_VERSION, produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    @GetMapping(GET_ALL_PRODUCTS_ENDPOINT)
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping(value = PRODUCT_ENDPOINT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDto> createNewProduct(final ProductDto productDto) {
        return ResponseEntity.ok(productService.createNewProduct(productDto));
    }

    @GetMapping(PRODUCT_PRODUCT_ID_ENDPOINT)
    public ResponseEntity<ProductDto> getProductById(@PathVariable final Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }
}
