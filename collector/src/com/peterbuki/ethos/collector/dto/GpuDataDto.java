package com.peterbuki.ethos.collector.dto;

public class GpuDataDto {
    private double temp;
    private double fan;
    private double hash;

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
