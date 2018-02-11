package com.peterbuki.ethos.collector.input;

import com.peterbuki.ethos.collector.dto.Dto;

import java.util.List;

public interface DataGenerator {
    public List<? extends Dto> getData();

    public void subscribe(DataListener listener) ;

    public void stop();

    public boolean isReady();

}
