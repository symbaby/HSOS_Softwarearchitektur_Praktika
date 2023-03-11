package de.hsos.mannschaft.control;

import de.hsos.mannschaft.utils.dto.patch.PlayerAttributesPatch;

import javax.enterprise.context.ApplicationScoped;


public interface IPlayersCrud {
    boolean setPlayerCondition(String id, PlayerAttributesPatch playerAttributesPatch);
}
