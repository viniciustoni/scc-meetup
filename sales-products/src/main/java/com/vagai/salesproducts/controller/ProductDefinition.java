package com.vagai.salesproducts.controller;

public final class ProductDefinition {

    private ProductDefinition(){}

    public static final String API_VERSION = "/v1";
    public static final String GET_ALL_PRODUCTS_ENDPOINT = "/products";
    public static final String PRODUCT_ENDPOINT = "/product";
    public static final String PRODUCT_PRODUCT_ID_ENDPOINT = PRODUCT_ENDPOINT + "/{productId}";

    public static final String STOCK_ENDPOINT = API_VERSION + "/stock";
    public static final String RESERVE_STOCK_ENDPOINT = "/reserve";
    public static final String ADD_STOCK_ENDPOINT = "/add";
    public static final String SOLD_STOCK_ENDPOINT = "/update-sold";
}
