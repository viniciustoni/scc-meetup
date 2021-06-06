package com.vagai.salesproducts.service;

import com.vagai.salesproducts.dto.AddProductStockDto;
import com.vagai.salesproducts.dto.ProductDto;
import com.vagai.salesproducts.dto.ReserveProductDto;
import com.vagai.salesproducts.dto.UpdateSoldStockDto;

public interface StockService {

    ProductDto reserveProduct(ReserveProductDto reserveProductDto);

    ProductDto updateSoldStock(UpdateSoldStockDto updateSoldStockDto);

    ProductDto addProductStock(AddProductStockDto addProductStockDto);

}
