package de.hsos.mannschaft.entity;

import de.hsos.mannschaft.utils.dto.post.TeamAttributesPost;
import de.hsos.mannschaft.utils.dto.post.TeamLinksPost;

public class Team {
    private String type;
    private String id;
    private TeamAttributes attributes;
    private TeamLinks links;
    private TeamRelationship teamRelationship;


    public Team(String type, String id, TeamAttributes attributes, TeamLinks links){
        this.type = type;
        this.id = id;
        this.attributes = attributes;
        this.links = links;
        this.teamRelationship = new TeamRelationship();
    }

    public Team(String type, String id, TeamAttributes attributes, TeamLinks links, TeamRelationship teamRelationship){
        this.type = type;
        this.id = id;
        this.attributes = attributes;
        this.links = links;
        this.teamRelationship = teamRelationship;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public TeamAttributes getAttributes() {
        return attributes;
    }

    public TeamLinks getLinks() {
        return links;
    }

    public TeamRelationship getTeamRelationship() {
        return teamRelationship;
    }



    // Setters were generated because we need them!
    // Ask how this could be solved better
    public void setType(String type) {
        this.type = type;
    }

    public void setAttributes(TeamAttributes attributes) {
        this.attributes = attributes;
    }

    public void setLinks(TeamLinks links) {
        this.links = links;
    }

    public void setTeamRelationship(TeamRelationship teamRelationship) {
        this.teamRelationship = teamRelationship;
    }

    @Override
    public String toString() {
        return "Team{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", attributes=" + attributes +
                ", links=" + links +
                '}';
    }
}
