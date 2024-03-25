package com.kibong.effective_java_study.creating_destroying_objects.constructor_many_parameters.illegal_argument_exception;

import java.time.LocalDate;

public class Order {

    public void updateDeliveryDate(LocalDate deliveryDate) {
        if (deliveryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("delivery date should be after today." + LocalDate.now());
        }
    }
}
