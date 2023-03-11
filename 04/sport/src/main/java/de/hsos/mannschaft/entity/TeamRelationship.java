package de.hsos.mannschaft.entity;

import java.util.ArrayList;
import java.util.List;

public class TeamRelationship {
    private Player manager;
    private List<Player> playerList;

    public TeamRelationship(){

    }

    public TeamRelationship(Player manager){
        this.manager = manager;
        this.playerList = new ArrayList<>();
    }

    public Player getManager() {
        return manager;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
