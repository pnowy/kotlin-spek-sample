package com.github.pnowy.spek;

import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class SimpleJUnit4Test {

    @Test
    public void shouldPrintInfoAboutJUnit4Test() throws Exception {
        System.out.println("JUnit 4 test");
    }
}
