package pt.estg.poo.inem.domain;

import pt.estg.poo.inembase.EmergencyMission;
import pt.estg.poo.inembase.EmergencyVehicle;
import java.time.LocalDate;

public abstract class AppVehicle extends EmergencyVehicle{
    private LocalDate lastInspectionDate;
    private LocalDate nextInspectionDate;
    private double weight;
    private boolean isOperational;
    
    // Gestão do array de missões
    private EmergencyMission[] missions;
    private int missionCount;
    private static final int INITIAL_CAPACITY = 5;

    public AppVehicle(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspectionDate, LocalDate nextInspectionDate, double weight, boolean isOperational) {
        super(manufacturer, incorporationDate, maxSpeed);
        this.lastInspectionDate = lastInspectionDate;
        this.nextInspectionDate = nextInspectionDate;
        this.weight = weight;
        this.isOperational = isOperational;
        this.missions = new EmergencyMission[INITIAL_CAPACITY];
        this.missionCount = 0;
    }

    public abstract String getId();

    public LocalDate getLastInspectionDate() {
        return lastInspectionDate;
    }

    public LocalDate getNextInspectionDate() {
        return nextInspectionDate;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public void setOperational(boolean operational) {
        isOperational = operational;
    }

    @Override
    public EmergencyMission[] getMissions(){
        EmergencyMission[] currentMissions = new EmergencyMission[missionCount];
        for (int i=0; i<missionCount; i++){
            currentMissions[i] = missions[i];
        }
        return currentMissions;
    }

    @Override
    public void addMission(EmergencyMission m) {
        if (m == null) {
            throw new IllegalArgumentException("A missão não pode ser nula.");
        }

        if (missionCount == missions.length) {
            resizeMissions();
        }

        missions[missionCount++] = m;
    }

    private void resizeMissions() {
        EmergencyMission[] newArray = new EmergencyMission[missions.length * 2];
        for (int i = 0; i < missionCount; i++) {
            newArray[i] = missions[i];
        }
        this.missions = newArray;
    }

    @Override
    public String toString() {
        return "Vehicle [" + getId() + "] - Fabricante: " + getManufacturer() + 
               " | Operacional: " + isOperational + " | Missões: " + missionCount;
    }
}
