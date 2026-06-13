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

    private void resizeMembers(){
        TeamMember[] newArray = new TeamMember[MAX_MEMBERS * 2];
        for (int i=0; i<members.length; i++){
            newArray[i] = members[i];
        }
        this.members = newArray;
    }

    public boolean addMember(TeamMember m){
        if (m==null){
            return false;
        }

        if (memberCount == MAX_MEMBERS){
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

    @Override
    public String toString() {
        String docName = (responsibleDoctor != null) ? responsibleDoctor.getName() : "Sem Médico";
        return "MedicalTeam [teamId=" + teamId + ", Doctor=" + docName + ", Total Members=" + memberCount + "]";
    }

}
