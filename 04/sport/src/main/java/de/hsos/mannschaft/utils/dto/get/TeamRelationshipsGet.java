package de.hsos.mannschaft.utils.dto.get;


import de.hsos.mannschaft.utils.dto.PlayerDTO;

import java.util.ArrayList;
import java.util.List;

public class TeamRelationshipsGet {
    public ManagerGet manager;
    public List<PlayerDTO> players;

    public TeamRelationshipsGet(){
        this.manager = new ManagerGet();
        this.players = new ArrayList<>();
    }
}
