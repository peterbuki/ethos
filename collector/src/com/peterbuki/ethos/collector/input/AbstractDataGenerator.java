package com.peterbuki.ethos.collector.input;

import com.peterbuki.ethos.collector.dto.Dto;
import com.peterbuki.ethos.collector.dto.GpuDataDto;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataGenerator implements DataGenerator {

    protected volatile List<DataListener> listeners = new ArrayList<>();
    protected volatile List<Dto> data = new ArrayList<>();

    protected volatile boolean running = false;
    protected volatile boolean ready = false;

    public void stop() {
        running = false;
    }

    public boolean isReady() {
        return ready;
    }

    @Override
    public List<Dto> getLatestData() {
        return data;
    }

    /**
     * All listeners will be notified when the data is updated
     *
     * @param listener the listener.update will be called
     */
    public void subscribe(DataListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners()
    {
        listeners.forEach(dataListener -> dataListener.update(data));
    }

    protected void updateData(List<Dto> newData)
    {
        data = newData;
        ready = true;
        notifyListeners();
    }


}
