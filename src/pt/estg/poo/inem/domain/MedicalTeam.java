package pt.estg.poo.inem.domain;

import java.io.Serializable;

public class MedicalTeam implements Serializable{
    private String teamId;
    private TeamMember[] members;
    private int memberCount;
    private Doctor responsibleDoctor;
    private static final int MAX_MEMBERS = 5;

    public MedicalTeam(String teamId,  Doctor responsibleDoctor){
        if (teamId == null){
            throw new IllegalArgumentException("O ID da equipa não pode ser nulo ou vazio.");
        }

        if (responsibleDoctor != null){
            throw new IllegalArgumentException("É obrigatório atribuir um médico responsável à equipa.");
        }

        this.teamId = teamId;
        this.members = new TeamMember[MAX_MEMBERS];
        this.memberCount = 0;
        this.responsibleDoctor = responsibleDoctor;

        this.addMember(responsibleDoctor);
    }

    public String getTeamId() {
        return teamId;
    }

    public Doctor getResponsibleDoctor() {
        return responsibleDoctor;
    }

    public void setResponsibleDoctor(Doctor responsibleDoctor) {
        if (responsibleDoctor == null) {
            throw new IllegalArgumentException("O médico responsável não pode ser nulo.");
        }
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

    private void resizeMembers(){
        TeamMember[] newArray = new TeamMember[members.length * 2];
        for (int i=0; i<members.length; i++){
            newArray[i] = members[i];
        }
        this.members = newArray;
    }

    public boolean addMember(TeamMember m){
        if (m == null) {
            throw new IllegalArgumentException("Não é possível adicionar um membro nulo.");
        }

        if (memberCount == members.length){
            resizeMembers();
        }

        for (int i=0; i<memberCount; i++){
            if (members[i].getNumber() == m.getNumber()){
                return false;
            }
        }
        members[memberCount++] = m;
        return true;
    }

    public boolean removeMember(TeamMember m){
        if (m == null) {
            throw new IllegalArgumentException("O membro a remover não pode ser nulo.");
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
     * Atualiza os dados de um membro existente na equipa.
     * @param memberNumber O número/ID do membro a atualizar.
     * @param updatedMember O novo objeto TeamMember com os dados corrigidos.
     * @return true se o membro foi encontrado e atualizado, false caso contrário.
     */
    public boolean updateMember(int memberNumber, TeamMember updTeamMember){
        if (updTeamMember == null) {
            throw new IllegalArgumentException("O membro atualizado não pode ser nulo.");
        }

        for (int i=0; i<memberCount; i++){
            if (members[i].getNumber() == memberNumber){
                // Atualiza o membro no array
                members[i] = updTeamMember;

                // Verifica se o membro atualizado era o médico responsável atual
                if (responsibleDoctor != null && responsibleDoctor.getNumber() == memberNumber){
                    if ("Doctor".equals(updTeamMember.getRole())) {
                        this.responsibleDoctor = (Doctor) updTeamMember; 
                    } else {
                        throw new IllegalArgumentException("Erro: O membro atualizado era o Médico Responsável e perdeu a categoria de Doctor!");
                    }
                }
                return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {
        String docName = (responsibleDoctor != null) ? responsibleDoctor.getName() : "Sem Médico";
        return "MedicalTeam [teamId=" + teamId + ", Doctor=" + docName + ", Total Members=" + memberCount + "]";
    }

}
