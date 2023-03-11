package de.hsos.mannschaft.utils.dto;

import de.hsos.mannschaft.entity.Player;

public class PlayerDTO {
    public String type;
    public String id;

    public PlayerDTO(){

    }

    public static PlayerDTO toDTO(Player player){
        PlayerDTO dto = new PlayerDTO();

        dto.type = player.getType();
        dto.id = player.getId();;

        return dto;
    }

}
