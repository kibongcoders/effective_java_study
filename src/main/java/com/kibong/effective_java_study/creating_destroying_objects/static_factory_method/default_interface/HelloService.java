package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method.default_interface;

public interface HelloService {

    String hello();

    default String bye() {
        prepareMessage();
        return "bye";
    }

    static String hi() {
        prepareMessage();
        return "hi";
    }

    static private void prepareMessage() {
    }
}
