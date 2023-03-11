package de.hsos.ssa.suchen.acl;

import de.hsos.ssa.suchen.bl.Ware;

public interface IDTOConverter {
    WareDTO wareToDTO(Ware ware);
    Ware DTOtoWare(WareDTO dto);
}
