package de.hsos.mannschaft.utils.dto.post;

public class TeamAttributesPost {
    public String name;
    public String category;

    public TeamAttributesPost(){

    }

    public TeamAttributesPost(String name, String category){
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "TeamAttributesPost{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
