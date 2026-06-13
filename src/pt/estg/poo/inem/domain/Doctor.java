package pt.estg.poo.inem.domain;


public class Doctor extends TeamMember{

    public Doctor(int number, String name, String role){
        super(number, name, "Doctor");
    }
    
    @Override
    public String toString() {
        return "Doctor [number=" + getNumber() + ", name=" + getName() + "]";
    }
}
