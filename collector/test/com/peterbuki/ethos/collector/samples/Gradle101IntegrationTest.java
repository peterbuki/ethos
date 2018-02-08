package com.peterbuki.ethos.collector.samples;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Gradle101IntegrationTest {


    private ByteArrayOutputStream output;

    @Before
    public void setUp()
    {
        output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);

        System.setOut(ps);
    }

    @Test
    public void outputTestForStatic()
    {
        Gradle101.main(new String[0]);

        assertEquals("Hello World!" + System.getProperty("line.separator"), output.toString());
    }

    @Ignore
    public void outputTestForStaticAlwaysFails()
    {
        Gradle101.main(new String[0]);

        assertEquals("Yo world!" + System.getProperty("line.separator"), output.toString());
    }


}
