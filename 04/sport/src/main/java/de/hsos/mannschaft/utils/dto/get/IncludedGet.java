package de.hsos.mannschaft.utils.dto.get;

public class IncludedGet {
    public String id;
    public String type;
    public TeamAttributesGet attributes;

    public IncludedGet(){

    }

    public IncludedGet(String id, String type, TeamAttributesGet attributes){
        this.id = id;
        this.type = type;
        this.attributes = attributes;
    }
}
