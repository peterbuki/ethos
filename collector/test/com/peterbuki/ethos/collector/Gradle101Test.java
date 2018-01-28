package com.peterbuki.ethos.collector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Gradle101Test {
    public Gradle101Test() { }

    private Gradle101 gradle;

    @Before
    public void setUp() {
        gradle = new Gradle101();
    }


    @Test
    public void helloTestPositive() {
        assertEquals("Hello World!", gradle.hello());
    }

    @Test
    public void helloTestAlwaysFails() {
        assertEquals("Yo World!", gradle.hello());
    }
}