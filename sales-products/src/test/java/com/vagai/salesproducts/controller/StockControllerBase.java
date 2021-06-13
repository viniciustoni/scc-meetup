package com.vagai.salesproducts.controller;

import com.vagai.salesproducts.dto.AddProductStockDto;
import com.vagai.salesproducts.dto.ProductDto;
import com.vagai.salesproducts.dto.ReserveProductDto;
import com.vagai.salesproducts.dto.UpdateSoldStockDto;
import com.vagai.salesproducts.handlers.ProductsExceptionHandler;
import com.vagai.salesproducts.service.StockService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.vagai.salesproducts.entity.enumerated.UnitOfMeasure.KILO;
import static com.vagai.salesproducts.entity.enumerated.UnitOfMeasure.METERS;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMessageVerifier
public class StockControllerBase {

    private static final Long PRODUCT_ID_ONE = 1L;
    private static final Long PRODUCT_ID_TWO = 2L;

    @Autowired
    private StockController stockController;

    @MockBean
    private StockService stockService;

    @BeforeEach
    public void setupTest() {
        // given
        given(stockService.addProductStock(any(AddProductStockDto.class))).willReturn(createProductOne());
        given(stockService.reserveProduct(any(ReserveProductDto.class))).willReturn(createProductOne());
        given(stockService.updateSoldStock(any(UpdateSoldStockDto.class))).willReturn(createProductTwo());

        // then
        RestAssuredMockMvc.standaloneSetup(stockController, new ProductsExceptionHandler());
    }

    private ProductDto createProductOne() {
        return ProductDto.builder()
                .productId(PRODUCT_ID_ONE)
                .name("Product One")
                .unitPrice(BigDecimal.valueOf(2.35).setScale(2, RoundingMode.HALF_UP))
                .unitOfMeasure(KILO)
                .qtdTotal(BigDecimal.valueOf(10).setScale(2, RoundingMode.HALF_UP))
                .qtdAvailable(BigDecimal.valueOf(5).setScale(2, RoundingMode.HALF_UP))
                .qtdReserved(BigDecimal.valueOf(3).setScale(2, RoundingMode.HALF_UP))
                .qtdSold(BigDecimal.valueOf(2).setScale(2, RoundingMode.HALF_UP))
                .build();
    }

    private ProductDto createProductTwo() {
        return ProductDto.builder()
                .productId(PRODUCT_ID_TWO)
                .name("Product Two")
                .unitPrice(BigDecimal.valueOf(4.78).setScale(2, RoundingMode.HALF_UP))
                .unitOfMeasure(METERS)
                .qtdTotal(BigDecimal.valueOf(20.5).setScale(2, RoundingMode.HALF_UP))
                .qtdAvailable(BigDecimal.valueOf(14).setScale(2, RoundingMode.HALF_UP))
                .qtdReserved(BigDecimal.valueOf(2.5).setScale(2, RoundingMode.HALF_UP))
                .qtdSold(BigDecimal.valueOf(4.0).setScale(2, RoundingMode.HALF_UP))
                .build();
    }
}
