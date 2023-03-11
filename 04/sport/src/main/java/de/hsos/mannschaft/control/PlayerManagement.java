package de.hsos.mannschaft.control;

import de.hsos.mannschaft.utils.dto.patch.PlayerAttributesPatch;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PlayerManagement implements IPlayersCrud{

    @Inject
    PlayerCrudImpl playerCrud;

    @Override
    public boolean setPlayerCondition(String id, PlayerAttributesPatch playerAttributesPatch) {
        return this.playerCrud.setPlayerCondition(id, playerAttributesPatch);
    }
}
