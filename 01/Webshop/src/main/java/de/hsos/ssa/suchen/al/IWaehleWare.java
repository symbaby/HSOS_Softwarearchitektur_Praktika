package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.acl.IWarenkorbFuerSuche;
import de.hsos.ssa.suchen.bl.Ware;

public interface IWaehleWare {
    boolean wareZuWarenkorbHinzufuegen(Ware ware, IWarenkorbFuerSuche warenkorb);
}
