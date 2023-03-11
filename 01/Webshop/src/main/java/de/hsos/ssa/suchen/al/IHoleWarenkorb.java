package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.acl.IWarenkorbFuerSuche;

public interface IHoleWarenkorb {
    public IWarenkorbFuerSuche holeWarenkorb();
    public IWarenkorbFuerSuche holeWarenkorb(int nummer);
}
