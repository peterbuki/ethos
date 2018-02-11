package com.peterbuki.ethos.collector.dto;

public class GpuDataDto extends AbstractDto {
    private double temp;
    private double fan;
    private double hash;

    @Override
    public String toString() {
        return String.format("GPU temp: %3.1f°C | fan speed: %3.1f%% | hash rate: %2.1fMh/s", temp, fan, hash);
    }
    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFan() {
        return fan;
    }

    public void setFan(double fan) {
        this.fan = fan;
    }

    public double getHash() {
        return hash;
    }

    public void setHash(double hash) {
        this.hash = hash;
    }
}
