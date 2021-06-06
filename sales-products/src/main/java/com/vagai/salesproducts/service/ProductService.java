package com.vagai.salesproducts.service;

import com.vagai.salesproducts.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProducts();

    ProductDto getProductById(Long productId);

    ProductDto createNewProduct(ProductDto productDto);

}
