package pt.estg.poo.inem.domain;

import java.time.LocalDateTime;

public class MedicalHelicopter extends AppVehicle {
    //Atributos
    private String registrationTailNumber; //Matricula aeronáutica
    private int maxFlightAltitude; //Altitude máxima de voo
    private int rotorCount; //Número de rotores

    //Construtor
    public MedicalHelicopter(String manufacturer, LocalDateTime incorporationDate, LocalDateTime lastInspectionDate, LocalDateTime nextInspectionDate, double weight, double maxSpeed, String registrationTailNumber, int maxFlightAltitude, int rotorCount){
        super(manufacturer, incorporationDate, lastInspectionDate, nextInspectionDate, weight, maxSpeed);
        this.registrationTailNumber = registrationTailNumber;
        this.maxFlightAltitude = maxFlightAltitude;
        this.rotorCount = rotorCount;
    }

    /**
     * Devolve a matricula aeronáutico associada ao helicoptero.
     * 
     * @return (matricula aeronáutica)
    */
    public String getRegistrationTailNumber(){
        return registrationTailNumber;
    }

    /**
     * Devolve a altitude máximo de voo associado ao helicoptero.
     * 
     * @return (altitude máxima)
    */
    public int getMaxFlightAltitude(){
        return maxFlightAltitude;
    }

    /**
     * Devolve o número de rotores associado ao helicoptero
     * 
     * @return (número de rotores )
    */
    public int getRotorCount(){
        return rotorCount;
    }

    /**
     * Devolve uma apresentação textual do helicóptero.
     * 
     * @return representação textual do helicóptero.
    */
    @Override
    public String toString(){
        return "\n Matricula Aeronáutica: " + getRegistrationTailNumber() +
               "\n Altitude Máxima: " + getMaxFlightAltitude() +
               "\n Número de Rotores: " + getRotorCount();
    }




}
