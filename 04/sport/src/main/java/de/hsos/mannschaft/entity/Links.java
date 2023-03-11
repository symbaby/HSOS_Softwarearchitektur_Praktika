package de.hsos.mannschaft.entity;

public class Links {
    private String self;
    private String related;

    public Links(){

    }

    public Links(String self, String related){
        this.self = self;
        this.related = related;
    }

    public String getSelf() {
        return this.self;
    }

    public String getRelated() {
        return this.related;
    }
}
