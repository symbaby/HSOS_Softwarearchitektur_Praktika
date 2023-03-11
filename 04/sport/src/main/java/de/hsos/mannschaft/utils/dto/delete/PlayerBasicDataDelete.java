package de.hsos.mannschaft.utils.dto.delete;

import de.hsos.mannschaft.entity.Player;

public class PlayerBasicDataDelete {
    public String type;
    public String id;

    public PlayerBasicDataDelete(){

    }

    public static Player fromDTO(PlayerBasicDataDelete playerBasicDataDelete) {
        return new Player(playerBasicDataDelete.type, playerBasicDataDelete.id);
    }
}
