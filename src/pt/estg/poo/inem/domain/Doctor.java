package pt.estg.poo.inem.domain;

public class Doctor {
    //Atributos
    private int id;
    private String name;

    //Atributos static
    private static int cont = 0;
    
    //Construtor
    public Doctor(String name){
        this.id = ++ cont;
        this.name = name;
    }

    //Métodos de Acesso

    /**
     * Devolve o id associada ao doutor.
     * 
     * @return (identificador do doutor)
    */
    public int getId(){
        return id;
    }

    /**
     * Devolve o nome associada ao doutor.
     * 
     * @return (nome do doutor)
    */
    public String getName(){
        return name;
    }

    //Método ToString
    @Override
    public String toString(){
        return "\n Id: " + getId() +
               "\n Nome: " + getName();
    }


    
}
