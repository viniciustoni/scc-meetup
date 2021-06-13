package com.vagai.salesproducts.service.impl;

import com.vagai.salesproducts.dto.ProductDto;
import com.vagai.salesproducts.entity.Product;
import com.vagai.salesproducts.exception.ProductNotFoundException;
import com.vagai.salesproducts.mapper.ProductMapper;
import com.vagai.salesproducts.repository.ProductRepository;
import com.vagai.salesproducts.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToProductDto)
                .collect(toList());
    }

    @Override
    public ProductDto getProductById(final Long productId) {
        return productRepository.findById(productId)
                .map(productMapper::mapToProductDto)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @Override
    @Transactional
    public ProductDto createNewProduct(final ProductDto productDto) {
        final Product product = productMapper.mapToProduct(productDto);
        final Product savedProduct = productRepository.save(product);

        return productMapper.mapToProductDto(savedProduct);
    }
}
