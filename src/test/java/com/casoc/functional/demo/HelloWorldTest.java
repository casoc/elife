package com.casoc.functional.demo;

import org.junit.runner.RunWith;
import org.concordion.integration.junit4.ConcordionRunner;

@RunWith(ConcordionRunner.class)
public class HelloWorldTest {
    public String sayHelloWorld() {
        return "HelloWorld";
    }
}
