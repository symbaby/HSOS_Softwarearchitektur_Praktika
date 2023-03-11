package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.acl.Warenkorb;
import de.hsos.ssa.suchen.bl.Produktinformation;
import de.hsos.ssa.suchen.bl.Ware;

public class PruefeWareImpl implements IPruefeWare {
    @Override
    public Produktinformation holeDetailinformationen(Ware ware) {

        return ware.getProduktinformation();
    }
}
