package com.peterbuki.ethos.collector.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class GpuDataDtoTest {

    @Test
    public void tests_to_string_method_with_all_data() {
        GpuDataDto dto = new GpuDataDto();
        dto.setMainHashRate(29.24);
        dto.setDualHashRate(201.1);
        dto.setMainAlgorithm(GpuDataDto.Algorithm.ETH);
        dto.setDualAlgorithm(GpuDataDto.Algorithm.PASC);
        dto.setTemp(100.45);
        dto.setFan(25.66);
        assertEquals("GPU temp: 100.5°C | fan speed: 25.7% | Ethereum hash rate: 29.2Mh/s | Pascal hash rate: 201.1Mh/s", dto.toString());
    }

    @Test
    public void tests_to_string_method_without_algos() {
        GpuDataDto dto = new GpuDataDto();
        dto.setMainHashRate(29.24);
        dto.setDualHashRate(201.1);
        dto.setTemp(100.45);
        dto.setFan(25.66);
        assertEquals("GPU temp: 100.5°C | fan speed: 25.7% | None hash rate: 29.2Mh/s | None hash rate: 201.1Mh/s", dto.toString());
    }
}