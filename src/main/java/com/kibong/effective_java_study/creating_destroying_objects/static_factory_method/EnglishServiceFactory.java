package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method;

public class EnglishServiceFactory implements HelloService{

    @Override
    public String hello() {
        return "English Hello";
    }
}
