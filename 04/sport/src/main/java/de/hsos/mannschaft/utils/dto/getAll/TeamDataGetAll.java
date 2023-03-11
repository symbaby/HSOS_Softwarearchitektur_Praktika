package de.hsos.mannschaft.utils.dto.getAll;


import de.hsos.mannschaft.entity.Team;

public class TeamDataGetAll {
    public String id;
    public String type;
    public TeamAttributesGetAll attributes;
    public TeamLinksGetAll links;

    public TeamDataGetAll(){
        this.attributes = new TeamAttributesGetAll();
        this.links = new TeamLinksGetAll();
    }


    public static TeamDataGetAll toDTO(Team team) {
        TeamDataGetAll dto = new TeamDataGetAll();

        dto.id = team.getId();
        dto.type = team.getType();
        dto.attributes.category = team.getAttributes().getCategory();
        dto.attributes.name = team.getAttributes().getName();
        dto.links.self = team.getLinks().getSelf();


        return dto;
    }
}
