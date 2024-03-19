package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method;

import com.kibong.effective_java_study.creating_destroying_objects.static_factory_method.enumeration.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.EnumSet;

@SpringBootTest
public class EnumerationTest {

    @Test
    public void enumerationValuesTest() {
        Arrays.stream(OrderStatus.values()).forEach(System.out::println);
    }

    @Test
    public void enumerationFieldsTest() {
        Arrays.stream(OrderStatus.values()).forEach(orderStatus ->
                System.out.println(orderStatus.getOrderStatusName()));
    }

    @Test
    public void enumerationSetTest() {
        EnumSet<OrderStatus> orderStatusEnumSet = EnumSet.allOf(OrderStatus.class);
        orderStatusEnumSet.forEach(System.out::println);
    }
}
