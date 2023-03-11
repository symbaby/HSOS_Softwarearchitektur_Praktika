package de.hsos.mannschaft.control;


import de.hsos.mannschaft.gateway.TeamRepository;
import de.hsos.mannschaft.utils.dto.delete.PlayerBasicDataDelete;
import de.hsos.mannschaft.utils.dto.get.TeamDataGet;
import de.hsos.mannschaft.utils.dto.get.TeamWithManagerGet;
import de.hsos.mannschaft.utils.dto.getAll.TeamDataGetAll;
import de.hsos.mannschaft.utils.dto.patch.TeamBasicDataPatch;
import de.hsos.mannschaft.utils.dto.patch.TeamDataPatch;
import de.hsos.mannschaft.utils.dto.post.PlayerBasicDataHolderPost;
import de.hsos.mannschaft.utils.dto.post.TeamDataPost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class TeamCrudImpl implements ITeamsCrud{

    @Inject
    TeamRepository teamRepository;

    @Override
    public Collection<TeamDataGetAll> getAllTeams() {
        return this.teamRepository.getAllTeams();
    }

    @Override
    public boolean addTeam(TeamDataPost teamDataPost) {
        return teamRepository.addTeam(teamDataPost);
    }

    @Override
    public boolean editTeam(TeamDataPatch teamDataPatch) {
        return teamRepository.editTeam(teamDataPatch);
    }

    @Override
    public TeamDataGet getTeamWithRelationship(String id) {
        return this.teamRepository.getTeamWithRelationship(id);
    }

    @Override
    public boolean assignTrainerToTeam(String id, TeamBasicDataPatch teamBasicDataPatch) {
        return this.teamRepository.assignTrainerToTeam(id, teamBasicDataPatch);
    }

    @Override
    public boolean assignPlayersToTeam(String id, PlayerBasicDataHolderPost playerBasicDataHolderPost) {
        return this.teamRepository.assignPlayersToTeam(id, playerBasicDataHolderPost);
    }

    @Override
    public boolean deletePlayerFromTeam(String id, PlayerBasicDataDelete playerBasicDataDelete) {
        return this.teamRepository.deletePlayerFromTeam(id, playerBasicDataDelete);
    }

    @Override
    public TeamWithManagerGet getTeamWithManager(String id, String include) {
        return this.teamRepository.getTeamWithManager(id, include);
    }


}
