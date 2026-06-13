package pt.estg.poo.inem.domain;

import java.time.LocalDate;

public class MedicalHelicopter extends AppVehicle {
    private String registrationTailNumber;
    private int maxFlightAltitude;
    private int rotorCount;

    public MedicalHelicopter(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspectionDate, LocalDate nextInspectionDate, double weight, boolean isOperational, String registrationTailNumber, int maxFlightAltitude, int rotorCount) {
        super(manufacturer, incorporationDate, maxSpeed, lastInspectionDate, nextInspectionDate, weight, isOperational);
        this.registrationTailNumber = registrationTailNumber;
        this.maxFlightAltitude = maxFlightAltitude;
        this.rotorCount = rotorCount;
    }

    @Override
    public String getId() {
        return this.registrationTailNumber;
    }

    public String getRegistrationTailNumber() {
        return registrationTailNumber;
    }

    public int getMaxFlightAltitude() {
        return maxFlightAltitude;
    }

    public int getRotorCount() {
        return rotorCount;
    }

    @Override
    public String toString() {
        return "Helicóptero [" + registrationTailNumber + "] - Rotores: " + rotorCount + " | " + super.toString();
    }
}
