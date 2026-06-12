package pt.estg.poo.inem.domain;

import java.time.LocalDateTime;

public class RapidResponseCar extends AppVehicle {
    //Atributos
    private String licensePlate; //Matricula
    private boolean advancedDefilibrator;

    //Construtor
    public RapidResponseCar(String manufacturer, LocalDateTime incorporationDate, LocalDateTime lastInspectionDate, LocalDateTime nextInspectionDate, double weight, double maxSpeed, String registrationTailNumber, int maxFlightAltitude, int rotorCount, String licensePlate, boolean advancedDefilibrator){
        super(manufacturer, incorporationDate, lastInspectionDate, nextInspectionDate, weight, maxSpeed);
        this.licensePlate = licensePlate;
        this.advancedDefilibrator = advancedDefilibrator;
    }

    //Métodos de acesso
    /**
     * Devolve a licença associada ao veículo (carro).
     * 
     * @return (licença)
    */
    public String getLicensePlate(){
        return licensePlate;
    }

    /**
     * Indica se o veículo possui desfibrilhador avançado.
     * 
     * @return (false = se tiver desfibrilhador avançado,
     * true = se não tiver desfibrilhador avançado).
    */
    public boolean hasAdvancedDefilibrator(){
        return advancedDefilibrator;
    }

    /**
     * Define o estado do desfibrilhador avançado.
     * 
     * @param advancedDefilibrator (novo estado do desfibrilhador).
     * 
     * @throws IllegalArgumentException se o desfibrilhador já se encontrar no estado pretendido.
    */
    public void setAdvancedDefilibrator(boolean advancedDefilibrator){
        if(this.advancedDefilibrator = advancedDefilibrator){
            throw new IllegalArgumentException("O estado do desfibrilhador já se encontra definido com esse valor");
        }

        this.advancedDefilibrator = advancedDefilibrator;
    }

    /**
     * Representação gráfica do carro.
     */
    @Override
    public String toString(){
        return "Matricula: " + getLicensePlate() +
               "Desfibrilhador Avançado: " + hasAdvancedDefilibrator();
    }







}
