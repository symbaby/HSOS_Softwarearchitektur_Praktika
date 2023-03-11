package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.acl.IWarenkorbFuerSuche;
import de.hsos.ssa.suchen.acl.Warenkorb;

public class HoleWarenkorbImpl implements IHoleWarenkorb {

    private final WarenkorbVerwalten warenkorbVerwalten;

    public HoleWarenkorbImpl() {
        this.warenkorbVerwalten = new WarenkorbVerwalten();
    }

    @Override
    public IWarenkorbFuerSuche holeWarenkorb() {
        System.out.println("Hole Warenkorb ab");
        return this.warenkorbVerwalten.holeWarenkorb();
    }

    @Override
    public IWarenkorbFuerSuche holeWarenkorb(int nummer) {
        return this.warenkorbVerwalten.holeWarenkorb(nummer);
    }
}
