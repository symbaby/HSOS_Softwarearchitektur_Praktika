package de.hsos.mannschaft.entity;

import de.hsos.mannschaft.utils.dto.post.TeamAttributesPost;

public class TeamAttributes {

    private String name;
    private String category;

    public TeamAttributes(){}

    public TeamAttributes(String name, String category){
        this.name=name;
        this.category=category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
