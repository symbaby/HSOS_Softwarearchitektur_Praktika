package de.hsos.mannschaft.utils.dto.post;


import de.hsos.mannschaft.entity.Team;
import de.hsos.mannschaft.entity.TeamAttributes;
import de.hsos.mannschaft.entity.TeamLinks;

public class TeamDataPost {
    public String type;
    public String id;
    public TeamAttributesPost attributes = new TeamAttributesPost();
    public TeamLinksPost links = new TeamLinksPost();

    public TeamDataPost() {
    }

    public static Team fromDTO(TeamDataPost teamDataPost) {
        TeamAttributes attributes = new TeamAttributes(teamDataPost.attributes.name, teamDataPost.attributes.category);
        TeamLinks links = new TeamLinks(teamDataPost.links.self, teamDataPost.links.related);
        return new Team(teamDataPost.type, teamDataPost.id, attributes, links);
    }

    @Override
    public String toString() {
        return "TeamDataPost{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", attributes=" + attributes +
                ", links=" + links +
                '}';
    }
}
