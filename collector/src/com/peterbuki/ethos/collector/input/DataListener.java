package com.peterbuki.ethos.collector.input;

import com.peterbuki.ethos.collector.dto.Dto;
import com.peterbuki.ethos.collector.dto.GpuDataDto;

import java.util.List;

public interface DataListener {
    void update(List<Dto> dto);
}
