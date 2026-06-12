package pt.estg.poo.inem.domain;

import java.time.LocalDateTime;

import pt.estg.poo.inem.Enums.LifeSupportLevel;

public class Ambulance extends AppVehicle {
    //Atributos
    private String licensePlate; //Matricula da Ambulancia
    private int stretcherCapacity; //Capacidade de Macas
    private LifeSupportLevel lifeSupportLevel; // Nivel de suporte de vida

    //Construtor
    public Ambulance(String manufacturer, LocalDateTime incorporationDate, LocalDateTime lastInspectionDate, LocalDateTime nextInspectionDate, double weight, double maxSpeed, String licensePlate, int stretcherCapacity, LifeSupportLevel lifeSupportLevel){
        super(manufacturer, incorporationDate, lastInspectionDate, nextInspectionDate, weight, maxSpeed);
        this.licensePlate = licensePlate;
        this.stretcherCapacity = stretcherCapacity;
        this.lifeSupportLevel = lifeSupportLevel;
    }

    //Métodos de Acesso

    /**
     * Devolve a matricula da ambulancia.
     * 
     * @return (matricula).
    */
    public String getLicensePlate(){
        return licensePlate;
    }

    /**
     * Devolve a capacidade de macas.
     * 
     * @return (capacidade de macas).
    */
    public int getStretcherCapacity(){
        return stretcherCapacity;
    }

    /**
     * Devolve o tipo de nivel do suporte de vida.
     * 
     * @return (nivel).
    */
    public LifeSupportLevel getLifeSupportLevel(){
        return lifeSupportLevel;
    }

    /**
     * Devolve uma apresentação textual da ambulancia
     * 
     * 
     * @return representação textual da ambulancia
    */
    @Override
    public String toString(){
        return "\n Matricula: " + getLicensePlate() +
               "\n Capacidade de Macas: " + getStretcherCapacity() +
               "\n Nivel do Suporte de Vida: " + getLifeSupportLevel();
    }
}
