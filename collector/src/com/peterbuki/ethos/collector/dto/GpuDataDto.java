package com.peterbuki.ethos.collector.dto;

public class GpuDataDto extends AbstractDto {
    private double temp = 0.0;
    private double fan = 0.0;
    private double mainHashRate = 0.0;
    private double dualHashRate = 0.0;
    private Algorithm mainAlgorithm = Algorithm.NONE;
    private Algorithm dualAlgorithm = Algorithm.NONE;

    public enum Algorithm {
        NONE("None", false), ETH("Ethereum", true), PASC("Pascal", false);
        public String name;
        public boolean main;

        Algorithm(String name, boolean main) {
            this.name = name;
            this.main = main;
        }
    }

    @Override
    public String toString() {
        return String.format("GPU temp: %3.1f°C | fan speed: %3.1f%% | %s hash rate: %2.1fMh/s | %s hash rate: %2.1fMh/s",
                        temp, fan, mainAlgorithm.name, mainHashRate, dualAlgorithm.name, dualHashRate);
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

    public double getMainHashRate() {
        return mainHashRate;
    }

    public void setMainHashRate(double hash) {
        this.mainHashRate = hash;
    }

    public double getDualHashRate() {
        return dualHashRate;
    }

    public void setDualHashRate(double hash) {
        this.dualHashRate = hash;
    }

    public void setMainAlgorithm(Algorithm mainAlgorithm) {
        this.mainAlgorithm = mainAlgorithm;
    }

    public void setDualAlgorithm(Algorithm dualAlgorithm) {
        this.dualAlgorithm = dualAlgorithm;
    }

    public Algorithm getMainAlgorithm() {
        return mainAlgorithm;
    }

    public Algorithm getDualAlgorithm() {
        return dualAlgorithm;
    }
}
