package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method;

import lombok.Getter;

@Getter
public class FinalProduct {
    private String productName;
    private Boolean productIsAvailable;
    private Boolean productIsExpired;
    private FinalProduct() {}

    private static final FinalProduct PRODUCT = new FinalProduct();

    public static FinalProduct newInstance() {
        return PRODUCT;
    }
}
