package de.hsos.mannschaft.utils.dto.post;

public class TeamLinksPost {
    public String self;
    public String related;

    public TeamLinksPost(){

    }

    public TeamLinksPost(String self, String related){
        this.self = self;
        this.related = related;
    }
}
