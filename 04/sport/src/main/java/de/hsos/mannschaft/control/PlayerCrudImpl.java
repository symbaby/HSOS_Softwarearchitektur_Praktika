package de.hsos.mannschaft.control;


import de.hsos.mannschaft.gateway.PlayerRepository;
import de.hsos.mannschaft.utils.dto.patch.PlayerAttributesPatch;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PlayerCrudImpl implements IPlayersCrud {

    @Inject
    PlayerRepository playerRepository;

    @Override
    public boolean setPlayerCondition(String id, PlayerAttributesPatch playerAttributesPatch) {
        return this.playerRepository.setPlayerCondition(id, playerAttributesPatch);
    }
}
