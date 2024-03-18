package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method;

public class HelloServiceFactory {

    public static HelloService newInstance(String language) {
        if (language.equals("ko")) {
            return new KoreanHelloService();
        } else {
            return new EnglishServiceFactory();
        }
    }
}

