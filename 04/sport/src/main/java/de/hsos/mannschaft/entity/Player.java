package de.hsos.mannschaft.entity;

import javax.inject.Inject;
import java.util.Objects;

public class Player {
    private String name;
    private String id;
    private String type;
    private Links links;
    private String condition = "healthy";

    public Player(String name, String type, String id, Links links){
        this.id = id;
        this.name = name;
        this.type = type;
        this.links = links;
    }

    public Player(String type, String id){
        this.type = type;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public String getType(){
        return this.type;
    }

    public Links getLinks() {
        return links;
    }

    public String getCondition() {
        return condition;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) && Objects.equals(getId(), player.getId()) && Objects.equals(getType(), player.getType()) && Objects.equals(getLinks(), player.getLinks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getType(), getLinks());
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
