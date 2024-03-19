package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method.enumeration;

import lombok.Getter;

@Getter
public enum OrderStatus {

    PREPARING("준비중"),
    SHIPPING("배송중"),
    DELIVERED("배송완료");

    private String orderStatusName;

    OrderStatus(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }
}
