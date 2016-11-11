package com.github.pnowy.spek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleJUnit5Test {

    @Test
    @DisplayName("should print info about junit5 test")
    public void exampleTest() {
        System.out.println("JUnit 5 test");
    }

}
