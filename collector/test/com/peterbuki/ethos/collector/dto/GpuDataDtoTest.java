package com.peterbuki.ethos.collector.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class GpuDataDtoTest {

    @Test
    public void tests_to_string_method() {
        GpuDataDto dto = new GpuDataDto();
        dto.setHash(29.24);
        dto.setTemp(100.45);
        dto.setFan(25.66);
        assertEquals("GPU temp: 100.5°C | fan speed: 25.7% | hash rate: 29.2Mh/s", dto.toString());
    }
}