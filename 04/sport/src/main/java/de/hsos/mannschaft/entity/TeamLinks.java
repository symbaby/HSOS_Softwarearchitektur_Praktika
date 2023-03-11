package de.hsos.mannschaft.entity;

public class TeamLinks {
    private String self;
    private String related;

    public TeamLinks() {

    }

    public TeamLinks(String self, String related) {
        this.self = self;
        this.related = related;
    }

    public String getSelf() {
        return this.self;
    }

    public String getRelated(){
        return this.related;
    }
}
