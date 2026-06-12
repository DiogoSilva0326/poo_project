package pt.estg.poo.inem.domain;

import java.time.LocalDateTime;


public abstract class AppVehicle {

    //Atributos
    private String manufacturer;
    private LocalDateTime incorporationDate;
    private LocalDateTime lastInspectionDate;
    private LocalDateTime nextInspectionDate;
    private double weight;
    private double maxSpeed;
    private boolean isOperational;
    private InemMission[] missions;
    private int missionCount;
    private int capacidade = 10; // Capacidade inicial de armazenamento de missões.

    //Construtor
    public AppVehicle(String manufacturer, LocalDateTime incorporationDate, LocalDateTime lastInspectionDate, LocalDateTime nextInspectionDate, double weight, double maxSpeed){
        this.manufacturer = manufacturer;
        this.incorporationDate = incorporationDate;
        this.lastInspectionDate = lastInspectionDate;
        this.nextInspectionDate = nextInspectionDate;
        this.missionCount = 0;
        this.missions = new InemMission[capacidade];
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.isOperational = false;
    }

    //Métodos de Acesso

    /**
     * Devolve o fabricante do veículo
     * 
     * @return (fabricante)
     * 
    */
    public String getManuFacturer(){
        return manufacturer;
    }

    /**
     * Devolve a data de incorporação do veiculo
     * 
     * @return (Data de incorporação)
     * 
    */
    public LocalDateTime getIncorporationDate(){
        return incorporationDate;
    }

    /**
     * Devolve a velocidade máxima do veiculo
     * 
     * @return (Velocidade máxima do veiculo)
     * 
    */
    public double getMaxSpeed(){
        return maxSpeed;
    }


    /**
     * Devolve a ultima data de inspeção do veículo
     * 
     * @return (Data da ultima inspeção)
     * 
    */
    public LocalDateTime getLastInspectionDate(){
        return lastInspectionDate;
    }

    /**
     * Define a data da última inspeção do veículo
     * 
     * @param lastInspectionDate (Nova data da última inspeção)
     * 
     * @IllegalArgumentException (A última inspeção deve ser anterior à próxima)
    */
    public void setLastInspectionDate(LocalDateTime lastInspectionDate){
        if (!lastInspectionDate.isBefore(this.nextInspectionDate)) {
            throw new IllegalArgumentException("A última inspeção deve ser anterior à próxima.");
        }
        this.lastInspectionDate = lastInspectionDate;
    }

    /**
     * Devolve a primeira data de inspeção do veículo
     * 
     * @return (Data da primeira inspeção)
     * 
    */
    public LocalDateTime getNextInspectionDate(){
        return nextInspectionDate;
    }

    /**
     * Define a próxima inspeção do veículo
     * 
     * @param nextInspectionDate (Nova data da próxima inspeção)
     * 
     * @IllegalArgumentException (Se a data da próxima inspeção não for posterior á data da ultima
     * inspeção, então lança erro)
     * 
    */
    public void setNextInspectionDate(LocalDateTime nextInspectionDate){
        if(!nextInspectionDate.isAfter(this.lastInspectionDate)){
            throw new IllegalArgumentException("A próxima inspeção deve ser posterior à última.");
        }
        this.nextInspectionDate = nextInspectionDate;
    }

    /**
     * Devolve o número de missoes do veículo
     * 
     * @return (Número de missões)
     */
    public int getMissionCount(){
        return missionCount;
    }

    /**
     * Devolve o número de missões de cada veículo
     * 
     * @return (Missões)
     */
    public InemMission[] getInemMission(){
        return missions;
    }

    /**
     * Devolve o peso do veículo
     * 
     * @return (Peso do veículo)
     * 
    */
    public double getWeight(){
        return weight;
    }

    /**
     * Devolve o estado do veículo
     * 
     * @return (False = Não Operacional, True = Operacional)
     * 
    */
    public boolean isOperational(){
        return isOperational;
    }

    /**
     * Define o estado do veículo
     * 
     * @param isOperational (Estado do veículo)
    */
    public void setOperational(Boolean isOperational){
        this.isOperational = isOperational;
    }

    //Métodos

    /**
     * Procura uma missão associada ao veículo
     * 
     * @param mission (missão a procurar)
     * 
     * @return índice do membro no array se existir,
     *         -1 caso não seja encontrado
    */
    public int searchMission(InemMission mission){

        for(int i = 0 ; i < missionCount ; i++){
            if (missions[i].equals(mission)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Método auxiliar que verifica se uma determinada missão pertence a um veículo
     * 
     * @param mission (missão a verificar)
     * 
     * @return true se missão estiver registada no veículo,
     *         false se a missão não existir
    */
    private boolean existsMission(InemMission mission){

        return searchMission(mission) != -1;
    }

    /**
     * Método auxiliar que aumenta a capacidade do array das missões
     * quando este atinge o seu limite.
    */
    private void resizeMissions(){

        InemMission temp[] = new InemMission[capacidade * 2];

        for(int i = 0; i < missionCount; i++){
            temp[i] = missions[i];
        }

        missions = temp;
    }

    /**
     * Adiciona uma nova missão a um veículo.
     * Caso a missão já exista, é lançada uma exceção.
     * Se a capacidade do array for atingida, o array é redimensionado.
     * 
     * 
     * @param newMission (missão a adicionar).
     * @throws IllegalArgumentException se a missão já estiver registada no veículo.
    */
    public void addMission(InemMission newMission){
        
        if (existsMission(newMission)) {
            throw new IllegalArgumentException("A missão já se encontra registada no veículo.");
        }

        if (missionCount == missions.length) {
            resizeMissions();
        }
        
        missions[missionCount] = newMission;
        missionCount++;
    }

    /**
     * Remove uma missão associada a um veículo.
     * Caso a missão não exista, é lançada uma exceção.
     * 
     * @param removeMember (missão a remover).
     * @throws IllegalArgumentException se a missão for inexistente.
    */
    public void removeMission(InemMission removeMission){
        if (!existsMission(removeMission)) {
            throw new IllegalArgumentException("Não é possível remover uma missão inexistente.");
        }

        int pos = searchMission(removeMission);

        for(int i = pos ; i < missionCount - 1; i++){
            missions[i] = missions [i + 1];
        }

        missions[missionCount - 1 ] = null;
        missionCount --;

    }

     /**
     * Atualiza a missão associada a um veículo.
     * 
     * Substitui uma missão existente por uma nova missão.
     * 
     * @param newMission (nova missão a associar ao veículo).
     * @param oldMission (missão atualmente registada que será substituida).
     * 
     * @throws IllegalArgumentException se a missão a substituir não existir.
     * @throws IllegalArgumentException se a nova missão já estiver registada no veículo.
    */
    public void updateMission(InemMission newMission, InemMission oldMission){
        if (!existsMission(oldMission)) {
            throw new IllegalArgumentException("A missão que pretende atualizar não se encontra registada no veículo.");
        }

        if (existsMission(newMission)){
            throw new IllegalArgumentException("A missão que pretende atualizar já se encontra registada no veículo");
        }

        int pos = searchMission(oldMission);

        missions[pos] = newMission;

    }

    /**
     * Lista todas as missões associadas ao veículo.
    */
    public void listMission(){
        for(int i = 0 ; i < missionCount ; i++){
            System.out.println(missions[i]);
        }
    }

    /**
     * Devolve uma apresentação textual do veiculo.
     * 
     * @return representação textual do veiculo
    */
    @Override
    public String toString(){
        return "\n Fabricante: " + getManuFacturer() + 
               "\n Data de Incorporação: " + getIncorporationDate() +
               "\n Velocidade Máxima: " + getMaxSpeed() +
               "\n Ultima Inspeção: " + getLastInspectionDate() +
               "\n Próxima Inspeção: " + getNextInspectionDate() +
               "\n Peso: " + getWeight() +
               "\n Missions: " + getInemMission() +
               "\n Número de Missões " + getMissionCount();

    }




}
