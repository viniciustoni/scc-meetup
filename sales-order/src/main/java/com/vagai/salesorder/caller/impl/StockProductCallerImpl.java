package com.vagai.salesorder.caller.impl;

import com.vagai.salesorder.caller.StockProductCaller;
import com.vagai.salesorder.dto.product.ProductDto;
import com.vagai.salesorder.dto.product.ReserveProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class StockProductCallerImpl implements StockProductCaller {

    @Value("${product.url}")
    private String productUrlPrefix;
    @Value("${product.url.reserve.product}")
    private String reserveProductUrlSuffix;

    private final RestTemplate restTemplate;

    @Override
    public ProductDto reserveProductItem(final ReserveProductDto reserveProductDto) {
        final URI reserveProduct = URI.create(productUrlPrefix + reserveProductUrlSuffix);
        return restTemplate.postForObject(reserveProduct, reserveProductDto, ProductDto.class);
    }
}
