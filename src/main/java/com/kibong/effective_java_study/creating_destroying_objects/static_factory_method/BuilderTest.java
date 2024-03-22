package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method;

public class BuilderTest {

    public static void main(String[] args) {
        new NutritionFacts.Builder(10, 10)
                .calories(10)
                .build();
    }
}
