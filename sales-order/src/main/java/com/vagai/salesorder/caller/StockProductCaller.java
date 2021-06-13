package com.vagai.salesorder.caller;

import com.vagai.salesorder.dto.product.ProductDto;
import com.vagai.salesorder.dto.product.ReserveProductDto;

public interface StockProductCaller {

    ProductDto reserveProductItem(ReserveProductDto reserveProductDto);

}
