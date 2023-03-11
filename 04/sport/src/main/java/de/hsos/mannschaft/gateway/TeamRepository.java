package de.hsos.mannschaft.gateway;

import de.hsos.mannschaft.entity.*;
import de.hsos.mannschaft.utils.dto.delete.PlayerBasicDataDelete;
import de.hsos.mannschaft.utils.dto.get.IncludedGet;
import de.hsos.mannschaft.utils.dto.get.TeamAttributesGet;
import de.hsos.mannschaft.utils.dto.get.TeamDataGet;
import de.hsos.mannschaft.utils.dto.get.TeamWithManagerGet;
import de.hsos.mannschaft.utils.dto.getAll.TeamDataGetAll;
import de.hsos.mannschaft.utils.dto.patch.TeamBasicDataPatch;
import de.hsos.mannschaft.utils.dto.patch.TeamDataPatch;
import de.hsos.mannschaft.utils.dto.post.PlayerBasicDataHolderPost;
import de.hsos.mannschaft.utils.dto.post.PlayerBasicDataPost;
import de.hsos.mannschaft.utils.dto.post.TeamDataPost;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ApplicationScoped
public class TeamRepository implements ITeamsCatalogue {

    private Map<String, Team> teamMap = new ConcurrentHashMap<>();

    public TeamRepository() {
        Team team1 = new Team("Fussball", "1", new TeamAttributes("Lohne FC", "Profi"),
                new TeamLinks(),
                new TeamRelationship(new Player("Coach Carter", "Coach", "100", new Links("localhost:8080/teams/1/relationships/manager", "localhost:8080/teams/1/manager"))));

        team1.getTeamRelationship().getPlayerList()
                .add(new Player("Berkan", "Spieler", "99", new Links("localhost:8080/teams/1/relationships/player", "localhost:8080/teams/1/relationships/manager")));

        team1.getTeamRelationship().getPlayerList()
                .add(new Player("Johannes", "Spieler", "69", new Links("localhost:8080/teams/1/relationships/player", "localhost:8080/teams/1/relationships/manager")));

        teamMap.put(team1.getId(), team1);
    }

    @Override
    public Collection<TeamDataGetAll> getAllTeams() {
        Map<String, TeamDataGetAll> teamsDTO = new HashMap<>();
        for (Team team : teamMap.values()) {
            teamsDTO.put(team.getId(), TeamDataGetAll.toDTO(team));
        }
        return teamsDTO.values();
    }

    @Override
    public boolean addTeam(TeamDataPost teamDataPost) {
        Team team = TeamDataPost.fromDTO(teamDataPost);
        if (!teamMap.containsKey(teamDataPost.id)) {
            teamMap.put(teamDataPost.id, team);
            return true;
        }
        return false;
    }

    @Override
    public boolean editTeam(TeamDataPatch teamDataPach) {
        if (teamMap.containsKey(teamDataPach.id)) {
            Team team = this.teamMap.get(teamDataPach.id);
            team.setType(teamDataPach.type);

            TeamAttributes teamAttributes = new TeamAttributes(team.getAttributes().getName(), teamDataPach.attributes.category);
            team.setAttributes(teamAttributes);
            return true;
        }
        return false;
    }

    @Override
    public TeamDataGet getTeamWithRelationship(String id) {
        return TeamDataGet.toDTO(this.teamMap.get(id));
    }

    @Override
    public boolean assignTrainerToTeam(String id, TeamBasicDataPatch teamBasicDataPatch) {
        if (this.teamMap.containsKey(id)) {
            Team team = this.teamMap.get(id);
            team.getTeamRelationship().getManager().setId(teamBasicDataPatch.id);
            team.getTeamRelationship().getManager().setType(teamBasicDataPatch.type);
            return true;
        }
        return false;
    }

    @Override
    public boolean assignPlayersToTeam(String id, PlayerBasicDataHolderPost playerBasicDataHolderPost) {
        if (this.teamMap.containsKey(id)) {
            Team team = this.teamMap.get(id);
            for (PlayerBasicDataPost p : playerBasicDataHolderPost.data) {
                Player player = PlayerBasicDataPost.fromDTO(p);
                team.getTeamRelationship().getPlayerList().add(player);
                System.out.println(p.id + " was added!");
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePlayerFromTeam(String id, PlayerBasicDataDelete playerBasicDataDelete) {
        if (this.teamMap.containsKey(id)) {
            Team team = this.teamMap.get(id);
            team.getTeamRelationship().getPlayerList().remove(PlayerBasicDataDelete.fromDTO(playerBasicDataDelete));
            return true;
        }
        return false;
    }

    @Override
    public TeamWithManagerGet getTeamWithManager(String id, String include) {

        if (this.teamMap.containsKey(id)) {
            Team team = this.teamMap.get(id);
            if (include.equals("manager")){

                TeamWithManagerGet teamWithManagerGet = new TeamWithManagerGet();
                teamWithManagerGet.data = TeamDataGet.toDTO(team);

                IncludedGet includedGet = new IncludedGet(team.getTeamRelationship().getManager().getId(),
                        team.getTeamRelationship().getManager().getType(),
                        new TeamAttributesGet(team.getTeamRelationship().getManager().getName()));

                teamWithManagerGet.includedList.add(includedGet);
                return teamWithManagerGet;
            }

            else if (include.equals("manager,player")) {
                TeamWithManagerGet teamWithManagerGet = new TeamWithManagerGet();
                teamWithManagerGet.data = TeamDataGet.toDTO(team);

                IncludedGet includedGet = new IncludedGet(
                        team.getTeamRelationship().getManager().getId(),
                        team.getTeamRelationship().getManager().getType(),
                        new TeamAttributesGet(team.getTeamRelationship().getManager().getName()));

                teamWithManagerGet.includedList.add(includedGet);

                for (Player p : team.getTeamRelationship().getPlayerList()) {
                    IncludedGet tmp = new IncludedGet(
                                p.getId(),
                                p.getType(),
                                new TeamAttributesGet(p.getName()));

                    teamWithManagerGet.includedList.add(tmp);
                }
                return teamWithManagerGet;
            }
        }
        return null;
    }

}
