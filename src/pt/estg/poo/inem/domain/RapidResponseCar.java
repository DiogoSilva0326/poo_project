package pt.estg.poo.inem.domain;

import java.time.LocalDate;

public class RapidResponseCar extends AppVehicle {
    private String licensePlate;
    private boolean hasAdvancedDefibrillator;

    public RapidResponseCar(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspectionDate, LocalDate nextInspectionDate, double weight, boolean isOperational, String licensePlate, boolean hasAdvancedDefibrillator) {
        super(manufacturer, incorporationDate, maxSpeed, lastInspectionDate, nextInspectionDate, weight, isOperational);
        this.licensePlate = licensePlate;
        this.hasAdvancedDefibrillator = hasAdvancedDefibrillator;
    }

    @Override
    public String getId() {
        return this.licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean hasAdvancedDefibrillator() {
        return hasAdvancedDefibrillator;
    }

    @Override
    public String toString() {
        String desfibrilhador = hasAdvancedDefibrillator ? "Sim" : "Não";
        return "VMER [" + licensePlate + "] - Desfibrilhador: " + desfibrilhador + " | " + super.toString();
    }
}
