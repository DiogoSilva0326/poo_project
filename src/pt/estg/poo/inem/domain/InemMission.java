package pt.estg.poo.inem.domain;

import java.time.LocalDateTime;
import pt.estg.poo.inem.Enums.EmergencyType;

public class InemMission {
    //Atributos
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EmergencyType type;
    private MissionContext context;
    private String description;
    private String authorizerName;
    private String authorizerRole;
    private MedicalTeam assignedTeam;

    //Construtor
    public InemMission(LocalDateTime startDate, LocalDateTime endDate, EmergencyType type, MissionContext context, String description, String authorizerName, String authorizerRole, MedicalTeam assignedTeam){
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.context = context;
        this.description = description;
        this.authorizerName = authorizerName;
        this.authorizerRole = authorizerRole;
        this.assignedTeam = assignedTeam;
    }

    //Métodos de acesso

    /**
    * Define a data de início da missão
    * 
    * @return a data de início.
    */ 
    public LocalDateTime getStartDate(){
        return startDate;
    }

    /**
    * Define a data de fim da missão
    * 
    * @return a data de fim.
    */
    public LocalDateTime getEndDate(){
        return endDate;
    }
    /**
     * Altera a data de fim da missão
     * 
     * A data de fim pode ser alterada porque a missão pode,
     * acabar antes do previsto, terminar mais tarde ou
     * ser corrigida.
     * 
     * 
     * @param endDate data de fim de missão
     * @throws IllegalArgumentException
     * se a data for anterior  á data de inicio
     * 
     */
    public void setEndDate(LocalDateTime endDate){
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Data de fim não pode ser anterior à data de início ");
        }
        this.endDate = endDate;
    }

    /**
    * Devolve a emergencia associada á missão.
    * 
    * O tipo de emergencia não pode ser alterado,
    * pois é defenido quando a missão é criada.
    * 
    * @return o tipo da emergencia
    */
    public EmergencyType getEmergencyType(){
        return type;
    }

    /**
    * Devolve o contexto da missão.
    * 
    * O contexto da missão também costuma ser definido no início
    * e permanecer fixo.
    * 
    * @return o contexto da missão.
    */
    public MissionContext getContext(){
        return context;
    }

    /**
    * Devolve a descricão associada á missão.
    * 
    * @return a descrição.
    */
    public String getDescription(){
        return description;
    }

    /**
    * Altera a descrição associada á missão.
    * 
    * A descrição pode ser alterada pois pode ser possivel
    * atualizar detalhes da missão.
    * 
    * @param description descrição da missão.
    */
    public void setDescription(String description){
        this.description = description;
    }

    /**
    * Devolve quem autorizou a missão.
    * 
    * Quem autoriza nao deve alterar depois.
    * 
    * @param authorizerName nome de quem autorizou.
    *  */ 
    public String getAuthorizerName(){
        return authorizerName;
    }

    /**
    * Devolve o cargo de quem autorizou a missão
    * 
    * O cargo do autorizador representa o cargo ocupado
    * no momento da missão em que foi criada.
    * 
    * @return o cargo do autorizador.
    */
    public String getAuthorizerRole(){
        return authorizerRole;
    }

    /**
     * Devolve a equipa médica associada á missão
     * 
     * @return a equipa médica
     */
    public MedicalTeam getAssignedTeam(){
        return assignedTeam;
    }

    /**
     * Altera a equipa médica associada á missão
     * 
     * A equipa médica pode ser alterada durante a execução da missão por
     * motivos operacionais ou imprevistos.
     * 
     * @param assignedTeam nova equipa médica
     */
    public void setMedicalTeam(MedicalTeam assignedTeam){
        this.assignedTeam = assignedTeam;
    }

    //Método ToString
    @Override
    public String toString(){
        return "\n StartDate: " + getStartDate() +
               "\n EndDate: " + getEndDate() +
               "\n Emergency Type: " + getEmergencyType() + 
               "\n Context: " + getContext() +
               "\n AuthorizerName: " + getAuthorizerName() +
               "\n AuthorizerRole: " + getAuthorizerRole() +
               "\n AssignedTeam: " + getAssignedTeam();
    }



}
