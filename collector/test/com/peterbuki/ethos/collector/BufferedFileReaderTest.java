package com.peterbuki.ethos.collector;

import org.junit.Test;

import static java.lang.Thread.sleep;

public class BufferedFileReaderTest {

    @Test
    public void runIt() throws InterruptedException {
        RollingFileWriter writer = new RollingFileWriter("test.out");
        writer.start();
        sleep(10000);
        writer.stop();
    }
}
