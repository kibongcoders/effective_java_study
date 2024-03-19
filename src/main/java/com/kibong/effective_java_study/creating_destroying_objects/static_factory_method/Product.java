package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method;

import com.kibong.effective_java_study.creating_destroying_objects.static_factory_method.enumeration.OrderStatus;
import lombok.Getter;

@Getter
public class Product {
    private String productName;
    private Boolean productIsAvailable;
    private Boolean productIsExpired;

    private OrderStatus orderStatus;
    public Product() {
    }

    public static Product createAvailableProduct(String productName, Boolean productIsAvailable) {
        Product product = new Product();
        product.productName = productName;
        product.productIsAvailable = productIsAvailable;
        product.productIsExpired = false;
        return product;
    }

    public static Product creteExpiredProduct(String productName, Boolean productIsExpired) {
        Product product = new Product();
        product.productName = productName;
        product.productIsExpired = productIsExpired;
        product.productIsAvailable = true;
        return product;
    }
}
