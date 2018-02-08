package com.peterbuki.ethos.collector.input;

import com.peterbuki.ethos.collector.dto.GpuDataDto;

import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Simple Data Generator for testing purposes.
 * It returns new dataset in every INTERVAL milliseconds
 */
public class SimpleDataGenerator {
    private final int INTERVAL;

    private volatile List<DataListener> listeners = new ArrayList<>();
    private volatile List<GpuDataDto> gpuData = new ArrayList<>();
    private volatile boolean running;

    private Thread mainThread;

    /**
     * All listeners will be notified when the data is updated
     *
     * @param listener the listener.update will be called
     */
    public void subscribe(DataListener listener) {
        listeners.add(listener);
    }

    private class MyThread implements Runnable
    {
        private Random random = new Random();
        @Override
        public void run() {
            while ( running )
            {
                GpuDataDto[] latestData = new GpuDataDto[8];
                for (int i=0; i<8; i++)
                {
                    latestData[i] = generateData();
                }
                gpuData = Arrays.asList(latestData);
                listeners.forEach(dataListener -> dataListener.update(gpuData));
                try
                { sleep(INTERVAL); }
                catch (InterruptedException e)
                { e.printStackTrace(); }
            }

        }

        /**
         * Generates data set.
         *
         * @return new GpuDataDto with random values
         */
        private GpuDataDto generateData()
        {
            GpuDataDto dto = new GpuDataDto();
            // return a value 0-100
            dto.setFan(random.nextInt(1000)/10);
            // return a value 0-50
            dto.setTemp(random.nextInt(500)/10);
            // return a value 0-50
            dto.setHash(random.nextInt(500)/10);
            return dto;
        }
    }


    public SimpleDataGenerator()
    {
        this(100);
    }

    public SimpleDataGenerator(int interval)
    {
        this.INTERVAL = interval;
        mainThread = new Thread(new MyThread());
        running = true;
        mainThread.start();
    }

    public List<GpuDataDto> getGpuData()
    {
        return gpuData;
    }

    public void stop()
    {
        running = false;
    }
    public boolean isReady()
    {
        return gpuData.size() != 0;
    }
}
