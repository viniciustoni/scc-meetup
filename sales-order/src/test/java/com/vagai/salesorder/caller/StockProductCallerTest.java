package com.vagai.salesorder.caller;

import com.vagai.salesorder.caller.impl.StockProductCallerImpl;
import com.vagai.salesorder.dto.product.ProductDto;
import com.vagai.salesorder.dto.product.ReserveProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;

@DirtiesContext
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.vagai:sales-products:+:stubs:8081")
class StockProductCallerTest {

    @Autowired
    private StockProductCaller stockProductCaller;

    @Test
    public void shouldReserveProductCorrectly() {
        // given
        final ReserveProductDto reserveProductDto = new ReserveProductDto(1L, BigDecimal.valueOf(2));

        // when
        final ProductDto productDto = stockProductCaller.reserveProductItem(reserveProductDto);

        // then
        Assertions.assertEquals(1L, productDto.getProductId());
        Assertions.assertEquals("Product One", productDto.getName());
        Assertions.assertEquals(BigDecimal.valueOf(2.35), productDto.getUnitPrice());
        Assertions.assertEquals("KILO", productDto.getUnitOfMeasure());
        Assertions.assertEquals(BigDecimal.valueOf(10), productDto.getQtdTotal());
        Assertions.assertEquals(BigDecimal.valueOf(5), productDto.getQtdAvailable());
        Assertions.assertEquals(BigDecimal.valueOf(3), productDto.getQtdReserved());
        Assertions.assertEquals(BigDecimal.valueOf(2), productDto.getQtdSold());
    }
}