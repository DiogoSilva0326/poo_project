package pt.estg.poo.inem.domain;

public class TeamMember {
    //Atributos
    private int number;
    private String name;
    private String role;

    //Atributos Static
    private static int cont = 0;
    
    //Construtor
    public TeamMember(String name, String role){
        this.number = ++cont;
        this.name = name;
        this.role = role;
    }

    //Métodos de Acesso

    /**
     * Devolve o identificador de cada membro da equipa
     * 
     * @return (id do membro)
     * 
    */
    public int getNumber(){
        return number;
    }

    /**
     * Devolve o nome de cada membro da equipa
     * 
     * @return (nome do membro)
     * 
    */
    public String getName(){
        return name;
    }

    /**
     * Devolve a função de cada membro da equipa
     * 
     * @return (função do membro)
    */
    public String getRole(){
        return role;
    }

    @Override
    public String toString(){
        return "Número: " + getNumber() +
               ", Nome: " + getName() +
               ", Função: " + getRole();
    }
}
 