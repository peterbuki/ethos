package com.peterbuki.ethos.collector.input;

import com.peterbuki.ethos.collector.dto.GpuDataDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SimpleDataGeneratorTest {

    private static final int INTERVAL = 100;
    private SimpleDataGenerator generator;
    private List<GpuDataDto> data = null;
    private int counter;


    @Before
    public void setup() {
        generator = new SimpleDataGenerator(INTERVAL);

    }

    @Test
    public void listener_is_updated() throws Exception {
        counter=0;
        generator.subscribe(gpuDataDto -> {
            data = gpuDataDto;
            System.out.println(String.format("Received data: #%d", counter));
            System.out.println(gpuDataDto.toString());
//            gpuDataDto.forEach(gpuDataDto1 -> System.out.println(gpuDataDto.toString()));
            counter++;
        });
        // let's wait for double the interval time to make sure we get notification
        sleep(INTERVAL*7+50);
        assertNotEquals("Should have been notified!", 0, counter);
        System.out.println("Got updates: " + counter);
    }

    @Test
    public void get_latest_data() throws Exception
    {
        // wait for the generator to get ready
        while ( ! generator.isReady() ) { sleep(100); }

        List<GpuDataDto> data = generator.getData();

        assertEquals("Must return 8 Dtos", 8, data.size() );
    }

    @After
    public void teardown()
    {
        generator.stop();
    }
}
