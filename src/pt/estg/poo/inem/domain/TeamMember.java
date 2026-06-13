package pt.estg.poo.inem.domain;

import java.io.Serializable;

public class TeamMember implements Serializable{
    private int number;
    private String name;
    private String role;

    public TeamMember(int number, String name, String role){
        this.number = number;
        this.name = name;
        this.role = role;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "TeamMember [number=" + number + ", name=" + name + ", role=" + role + "]";
    }
}
