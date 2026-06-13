package pt.estg.poo.inem.domain;

import java.io.Serializable;

public class MedicalTeam implements Serializable{
    private String teamId;
    private TeamMember[] members;
    private int memberCount;
    private Doctor responsibleDoctor;
    private static final int MAX_MEMBERS = 5;

    public MedicalTeam(String teamId,  Doctor responsibleDoctor){
        this.teamId = teamId;
        this.members = new TeamMember[MAX_MEMBERS];
        this.memberCount = 0;
        if (responsibleDoctor != null){
            this.addMember(responsibleDoctor);
        }
    }

    public String getTeamId() {
        return teamId;
    }

    public Doctor getResponsibleDoctor() {
        return responsibleDoctor;
    }

    /**
     * Altera o doutor responsável da equipa médica.
     * 
     * O doutor responsável pode ser alterado caso
     * seja substituido por algum motivo especifico.
     * 
     * @param responsibleDoctor
    */
    public void setResponsibleDoctor(Doctor responsibleDoctor) {
        this.responsibleDoctor = responsibleDoctor;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public TeamMember[] getMembers(){
        TeamMember[] currenTeamMembers = new TeamMember[memberCount];
        for (int i=0; i<memberCount; i++){
            currenTeamMembers[i] = members[i];
        }
        return currenTeamMembers;
    }

    /**
     * Método auxiliar que aumenta a capacidade do array de membros
     * quando este atinge o seu limite.
    */
    private void resizeMembers(){
        TeamMember[] newArray = new TeamMember[MAX_MEMBERS * 2];
        for (int i=0; i<members.length; i++){
            newArray[i] = members[i];
        }
        this.members = newArray;
    }


    //Métodos

    /**
     * Procura um membro da equipa
     * 
     * @param member (membro a procurar)
     * @return índice do membro no array se existir,
     *         -1 caso não seja encontrado
    */
    public int searchMember(TeamMember member){
        for(int i = 0 ; i < memberCount ; i++){
            if (members[i].equals(member)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Método auxiliar que verifica se um determinado membro pertence á equipa
     * 
     * @param member (membro a verificar)
     * 
     * @return true se o membro existir na equipa,
     *         false se o membro não existir
    */
    private boolean exists(TeamMember member){
        return searchMember(member) != -1;
    }


    /**
     * Adiciona um novo membro á equipa.
     * Caso o membro já exista, é lançada uma exceção.
     * Se a capacidade do array for atingida, o array é redimensionado.
     * 
     * 
     * @param newMember (novo membro a adicionar á equipa)
     * @throws IllegalArgumentException se o membro já existir na equipa
    */
    public void addMember(TeamMember newMember){
        if (exists(newMember)) {
            throw new IllegalArgumentException("O membro já existe");
        }

        if (memberCount == members.length) {
            resizeMembers();
        }

        members[memberCount] = newMember;
        memberCount++;
    }

    /**
     * Remove um membro da equipa.
     * Caso o membro não exista, é lançada uma exceção.
     * 
     * @param removeMember (membro a remover)
     * @throws IllegalArgumentException se o membro não existir na equipa
    */
    public boolean removeMember(TeamMember m){
        if (m == null){
            return false;
        }

        for (int i=0; i<memberCount; i++){
            if (members[i].getNumber() == m.getNumber()){
                members[i] = members[memberCount - 1];
                members[memberCount - 1] = null;
                memberCount--;
                return true;
            }
        }
        return false;
    }

    /**
     * Devolve uma apresentação textual da equipa médica,
     * incluindo o identificador da equipa, o médico responsável
     * e a lsta de membros associados.
     * 
     * @return representação textual da equipa médica
    */
    @Override
    public String toString() {
        String docName = (responsibleDoctor != null) ? responsibleDoctor.getName() : "Sem Médico";
        return "MedicalTeam [teamId=" + teamId + ", Doctor=" + docName + ", Total Members=" + memberCount + "]";
    }  

}
