package com.vagai.salesproducts.controller;

import com.vagai.salesproducts.dto.ProductDto;
import com.vagai.salesproducts.exception.ProductNotFoundException;
import com.vagai.salesproducts.handlers.ProductsExceptionHandler;
import com.vagai.salesproducts.service.ProductService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static com.vagai.salesproducts.entity.enumerated.UnitOfMeasure.KILO;
import static com.vagai.salesproducts.entity.enumerated.UnitOfMeasure.METERS;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

// A little bit simpler the conf
@SpringBootTest(classes = ProductController.class)
public class ProductControllerBase {

    private static final Long PRODUCT_ID_ONE = 1L;
    private static final Long PRODUCT_ID_TWO = 2L;
    private static final Long PRODUCT_ID_THREE = 3L;

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @BeforeEach
    public void setupTest() {
        // given
        given(productService.getProducts()).willReturn(Arrays.asList(createProductOne(), createProductTwo()));
        given(productService.getProductById(PRODUCT_ID_ONE)).willReturn(createProductOne());
        given(productService.getProductById(PRODUCT_ID_THREE)).willThrow(new ProductNotFoundException(PRODUCT_ID_THREE));
        given(productService.createNewProduct(any(ProductDto.class))).willReturn(createProductOne());

        // then
        RestAssuredMockMvc.standaloneSetup(productController, new ProductsExceptionHandler());
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
