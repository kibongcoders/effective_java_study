package com.kibong.effective_java_study.creating_destroying_objects.static_factory_method;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.ServiceLoader;

import static com.kibong.effective_java_study.creating_destroying_objects.static_factory_method.Product.creteExpiredProduct;

@SpringBootTest
@Slf4j
public class StaticFactoryMethodTest {

    @Test
    public void staticFactoryMethodTest() {
        Product availableProduct = Product.createAvailableProduct("availableProduct", true);
        Product expiredProduct = creteExpiredProduct("expiredProduct", true);
    }

    @Test
    public void newInstanceTest() {
        Product product = new Product();
        Product product1 = new Product();
        Product product2 = new Product();

        log.info("product: " + product);
        log.info("product1: " + product1);
        log.info("product2: " + product2);
    }

    @Test
    public void newFinalInstanceTest(){
        FinalProduct finalProduct = FinalProduct.newInstance();
        FinalProduct finalProduct1 = FinalProduct.newInstance();
        FinalProduct finalProduct2 = FinalProduct.newInstance();

        log.info("finalProduct: " + finalProduct);
        log.info("finalProduct1: " + finalProduct1);
        log.info("finalProduct2: " + finalProduct2);
    }

    @Test
    public void interfaceTest() {
        HelloService helloService = HelloServiceFactory.newInstance("ko");
        log.info("helloService: " + helloService.hello());
        log.info("helloService: " + helloService.bye());
    }

    @Test
    public void defaultMethodTest(){
        ServiceLoader<HelloService> load = ServiceLoader.load(HelloService.class);
        Optional<HelloService> first = load.findFirst();
        first.ifPresent(helloService -> log.info(helloService.hello()));
    }
}
