package pt.estg.poo.inem.domain;

import pt.estg.poo.inembase.Doctor;
import pt.estg.poo.inembase.TeamMember;

public class MedicalTeam {

    //Atributos
    private int teamId;
    private TeamMember[] members;
    private int memberCount;
    private Doctor responsibleDoctor;

    //Atributos static
    private static int count = 0;
    private static final int MAX_MEMBERS = 10;

    //Construtor
    public MedicalTeam(Doctor responsibleDoctor){
        this.teamId = ++ count;
        this.members = new TeamMember[MAX_MEMBERS];
        this.memberCount = 0;
        this.responsibleDoctor = responsibleDoctor;
    }

    //Métodos de acesso

    /**
     * Devolve o id associada á equipa médica.
     * 
     * @return o id da equipa
     */
    public int getTeamId(){
        return teamId;
    }

    /**
     * Devolve os membros da equipa médica
     * 
     * @return os membros da equipa
     */
    public TeamMember[] getTeamMembers(){
        return members;
    }  

    /**
     * Devolve o numero de membros da equipa.
     * 
     * @return o numero de membros.
     */
    public int getMemberCount(){
        return memberCount;
    }
    
    /**
     * Devolve o doutor responsavel da equipa médica
     * 
     * @return o doutor responsavel
     */
    public Doctor getResponsibleDoctor(){
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
    public void setReponsibleDoctor(Doctor responsibleDoctor){
        this.responsibleDoctor = responsibleDoctor;
    }

    //Métodos
    public int searchMember(TeamMember member){
        for(int i = 0 ; i < memberCount ; i++){
            if (members[i].equals(member)) {
                return i;
            }
        }
        return -1;
    }

    private boolean exists(TeamMember member){
        return searchMember(member) != -1;
    }

    private void resizeMembers(){

        TeamMember[] temp = new TeamMember[members.length * 2];

            for(int i = 0; i < memberCount; i ++){
                temp[i] = members[i];
            
            members = temp;
        }

    }

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

    public void removeMember(TeamMember removeMember){
        if (!exists(removeMember)) {
            throw new IllegalArgumentException("Impossivel remover um membro existente");
        }

        int pos = searchMember(removeMember);

        for(int i = pos ; i < memberCount - 1 ; i++){
            members[i] = members[i + 1];
        }

        members[memberCount - 1 ] = null;
        memberCount --;
    }

    @Override
    public String toString(){
        String result ="\nId Team: " + getTeamId() +
                       "\nDoctor: " + getResponsibleDoctor() + 
                       "\nMembers:\n";
                            for(int i = 0; i < memberCount; i++){
                                    result += members[i] + "\n"; 
                            }

                    return result;
    }   

}
