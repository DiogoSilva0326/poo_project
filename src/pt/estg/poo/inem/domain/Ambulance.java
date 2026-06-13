package pt.estg.poo.inem.domain;

import java.time.LocalDate;

public class Ambulance extends AppVehicle {
    private String licensePlate;
    private int stretcherCapacity;
    private String lifeSupportLevel;

    public Ambulance(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspectionDate, LocalDate nextInspectionDate, double weight, boolean isOperational, String licensePlate, int stretcherCapacity, String lifeSupportLevel) {
        super(manufacturer, incorporationDate, maxSpeed, lastInspectionDate, nextInspectionDate, weight, isOperational);
        this.licensePlate = licensePlate;
        this.stretcherCapacity = stretcherCapacity;
        this.lifeSupportLevel = lifeSupportLevel;
    }

    @Override
    public String getId(){
        return this.licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getStretcherCapacity() {
        return stretcherCapacity;
    }

    public String getLifeSupportLevel() {
        return lifeSupportLevel;
    }

    @Override
    public String toString() {
        return "Ambulância [" + licensePlate + "] - Suporte: " + lifeSupportLevel + " | " + super.toString();
    }
}
