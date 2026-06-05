package pt.estg.poo.inem.domain;

public class MedicalTeam {

    //Atributos
    private int teamId;
    private TeamMember[] members;
    private int memberCount;
    private Doctor responsibleDoctor;
    
    //Atributos static
    private static int count = 0;
    private static final int MAX_MEMBERS = 10;

    //Constrtor
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
     * Método auxiliar que aumenta a capacidade do array de membros
     * quando este atinge o seu limite.
    */
    private void resizeMembers(){

        TeamMember[] temp = new TeamMember[members.length * 2];

            for(int i = 0; i < memberCount; i ++){
                temp[i] = members[i];
            
            members = temp;
        }

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

    /**
     * Devolve uma apresentação textual da equipa médica,
     * incluindo o identificador da equipa, o médico responsável
     * e a lsta de membros associados.
     * 
     * @return representação textual da equipa médica
    */
    @Override
    public String toString(){
        String result ="\nId: " + getTeamId() +
                       "\nDoutor: " + getResponsibleDoctor() + 
                       "\nMembros:\n";

        for(int i = 0; i < memberCount; i++){
            result += members[i] + "\n"; 
        }

        return result;
    }   

}
