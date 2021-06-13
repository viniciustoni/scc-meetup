package com.vagai.salesproducts.service.impl;

import com.vagai.salesproducts.dto.AddProductStockDto;
import com.vagai.salesproducts.dto.ProductDto;
import com.vagai.salesproducts.dto.ReserveProductDto;
import com.vagai.salesproducts.dto.UpdateSoldStockDto;
import com.vagai.salesproducts.entity.Product;
import com.vagai.salesproducts.exception.ProductNotFoundException;
import com.vagai.salesproducts.mapper.ProductMapper;
import com.vagai.salesproducts.repository.ProductRepository;
import com.vagai.salesproducts.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto reserveProduct(final ReserveProductDto reserveProductDto) {
        return productRepository.findById(reserveProductDto.getProductId())
                .map(product -> updateQtdReserved(product, reserveProductDto.getQtdReserved()))
                .map(productMapper::mapToProductDto)
                .orElseThrow(() -> new ProductNotFoundException(reserveProductDto.getProductId()));
    }

    @Override
    @Transactional
    public ProductDto updateSoldStock(final UpdateSoldStockDto updateSoldStockDto) {
        return productRepository.findById(updateSoldStockDto.getProductId())
                .map(product -> updateQtdSold(product, updateSoldStockDto.getQtdSold()))
                .map(productMapper::mapToProductDto)
                .orElseThrow(() -> new ProductNotFoundException(updateSoldStockDto.getProductId()));
    }

    @Override
    @Transactional
    public ProductDto addProductStock(final AddProductStockDto addProductStockDto) {
        return productRepository.findById(addProductStockDto.getProductId())
                .map(product -> addMoreProductsToStock(product, addProductStockDto.getQtdAdded()))
                .map(productMapper::mapToProductDto)
                .orElseThrow(() -> new ProductNotFoundException(addProductStockDto.getProductId()));
    }

    private Product updateQtdSold(final Product product, final BigDecimal qtdSold) {
        if (product.getQtdSold() != null) {
            product.setQtdSold(product.getQtdSold().add(qtdSold));
        } else {
            product.setQtdSold(qtdSold);
        }
        product.setQtdReserved(product.getQtdReserved().subtract(qtdSold));

        return product;
    }

    private Product updateQtdReserved(final Product product, final BigDecimal qtdReserved) {
        // TODO: check if we have qtd to reserve
        if (product.getQtdReserved() != null) {
            product.setQtdReserved(product.getQtdReserved().add(qtdReserved));
        } else {
            product.setQtdReserved(qtdReserved);
        }
        product.setQtdAvailable(product.getQtdAvailable().subtract(qtdReserved));

        return product;
    }

    private Product addMoreProductsToStock(final Product product, final BigDecimal qtdToAdd) {
        product.setQtdTotal(product.getQtdTotal().add(qtdToAdd));
        product.setQtdAvailable(product.getQtdAvailable().add(qtdToAdd));

        return product;
    }
}
