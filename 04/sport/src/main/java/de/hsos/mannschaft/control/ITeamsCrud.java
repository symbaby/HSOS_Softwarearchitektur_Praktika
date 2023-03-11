package de.hsos.mannschaft.control;

import de.hsos.mannschaft.utils.dto.delete.PlayerBasicDataDelete;
import de.hsos.mannschaft.utils.dto.get.TeamDataGet;
import de.hsos.mannschaft.utils.dto.get.TeamWithManagerGet;
import de.hsos.mannschaft.utils.dto.getAll.TeamDataGetAll;
import de.hsos.mannschaft.utils.dto.patch.TeamBasicDataPatch;
import de.hsos.mannschaft.utils.dto.patch.TeamDataPatch;
import de.hsos.mannschaft.utils.dto.post.PlayerBasicDataHolderPost;
import de.hsos.mannschaft.utils.dto.post.TeamDataPost;

import java.util.Collection;

public interface ITeamsCrud {

    Collection<TeamDataGetAll> getAllTeams();

    boolean addTeam(TeamDataPost teamDataPost);

    boolean editTeam(TeamDataPatch teamDataPatch);


    TeamDataGet getTeamWithRelationship(String id);


    boolean assignTrainerToTeam(String id, TeamBasicDataPatch teamBasicDataPatch);

    boolean assignPlayersToTeam(String id, PlayerBasicDataHolderPost playerBasicDataHolderPost);

    boolean deletePlayerFromTeam(String id, PlayerBasicDataDelete playerBasicDataDelete);

    TeamWithManagerGet getTeamWithManager(String id, String include);


}
