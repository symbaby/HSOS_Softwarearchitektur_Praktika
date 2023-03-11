package de.hsos.mannschaft.utils.dto.get;

import de.hsos.mannschaft.entity.Player;
import de.hsos.mannschaft.entity.Team;
import de.hsos.mannschaft.utils.dto.PlayerDTO;


public class TeamDataGet {
    public String id;
    public String type;
    public TeamAttributesGet attributes;
    public TeamRelationshipsGet relationships;

    public TeamDataGet() {

    }

    public static TeamDataGet toDTO(Team team) {
        TeamDataGet teamDataGet = new TeamDataGet();
        teamDataGet.id = team.getId();
        teamDataGet.type = team.getType();

        TeamAttributesGet attributesGet = new TeamAttributesGet();
        attributesGet.name = team.getAttributes().getName();
        teamDataGet.attributes = attributesGet;

        // Relationship setten
        TeamRelationshipsGet r = new TeamRelationshipsGet();
        r.manager.basicData.id = team.getTeamRelationship().getManager().getId();
        r.manager.basicData.type = team.getTeamRelationship().getManager().getType();

        r.manager.links.self = team.getTeamRelationship().getManager().getLinks().getSelf();
        r.manager.links.related = team.getTeamRelationship().getManager().getLinks().getRelated();


        // r.players.addAll(team.getTeamRelationship().getPlayerList());
        for(Player t : team.getTeamRelationship().getPlayerList()){
            PlayerDTO dto = PlayerDTO.toDTO(t);
            r.players.add(dto);
        }

        teamDataGet.relationships = r;

        return teamDataGet;
    }
}
