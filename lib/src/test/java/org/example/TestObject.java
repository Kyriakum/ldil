package org.example;

import com.kyriakum.ldil.annotations.Inject;

public class TestObject {

    @Inject
    TestInterface testInterface;

    @Inject
    TestConcreteSingleton testConcreteSingleton;

    public String getString(){
        return testInterface.hello();
    }

    public TestInterface getTestInterface() {
        return testInterface;
    }

    public TestConcreteSingleton getTestConcreteSingleton() {
        return testConcreteSingleton;
    }
}
