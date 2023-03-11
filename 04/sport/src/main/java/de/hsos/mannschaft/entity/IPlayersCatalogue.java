package de.hsos.mannschaft.entity;

import de.hsos.mannschaft.utils.dto.patch.PlayerAttributesPatch;

public interface IPlayersCatalogue {
    boolean setPlayerCondition(String id, PlayerAttributesPatch playerAttributesPatch);
}
