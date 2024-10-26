package org.example;

import com.kyriakum.ldil.annotations.objecttype.Prototype;

@Prototype
public class TestConcrete implements TestInterface {

    public String hello(){
        return "Hello World!";
    }

}
