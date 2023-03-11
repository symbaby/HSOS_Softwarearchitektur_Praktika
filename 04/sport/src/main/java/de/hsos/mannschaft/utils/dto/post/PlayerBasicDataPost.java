package de.hsos.mannschaft.utils.dto.post;

import de.hsos.mannschaft.entity.Player;

public class PlayerBasicDataPost {
    public String type;
    public String id;

    public PlayerBasicDataPost(){

    }

    public static Player fromDTO(PlayerBasicDataPost p) {
        return new Player(p.type, p.id);
    }
}
