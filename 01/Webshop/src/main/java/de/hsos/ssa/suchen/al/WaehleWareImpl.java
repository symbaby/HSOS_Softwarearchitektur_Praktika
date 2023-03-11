package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.acl.IWarenkorbFuerSuche;
import de.hsos.ssa.suchen.acl.WareDTO;
import de.hsos.ssa.suchen.bl.Ware;

public class WaehleWareImpl implements IWaehleWare {

    private WarenkorbVerwalten warenkorbVerwalten;

    public WaehleWareImpl() {
        this.warenkorbVerwalten = new WarenkorbVerwalten();
    }

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware, IWarenkorbFuerSuche warenkorb) {

        if (ware == null || warenkorb == null) {
            return false;
        } else {
            WareDTO tmp = this.warenkorbVerwalten.getWareDto().wareToDTO(ware);
            warenkorb.wareHinzufuegen(tmp);

            System.out.println("Warenkorb: " + warenkorb + " wurde erweitert");
            return true;
        }
    }
}
