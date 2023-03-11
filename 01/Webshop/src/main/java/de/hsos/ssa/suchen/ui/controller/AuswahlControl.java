package de.hsos.ssa.suchen.ui.controller;


import de.hsos.ssa.suchen.acl.IWarenkorbFuerSuche;
import de.hsos.ssa.suchen.acl.Warenkorb;
import de.hsos.ssa.suchen.bl.Geld;
import de.hsos.ssa.suchen.bl.Produktinformation;
import de.hsos.ssa.suchen.bl.Ware;
import de.hsos.ssa.suchen.ui.model.AuswahlModel;
import de.hsos.ssa.suchen.ui.view.AuswahlView;
import de.hsos.ssa.suchen.al.IWaehleWare;

public class AuswahlControl {
    private AuswahlModel auswahlModel;
    private AuswahlView auswahlView;

    private IWaehleWare waehleWare;

    public AuswahlControl(IWaehleWare waehleWare) {
        this.auswahlModel = new AuswahlModel();
        this.auswahlView = new AuswahlView();
        this.waehleWare = waehleWare;
    }


    public void menueAuswahl(Ware ware, IWarenkorbFuerSuche warenkorb) {
        int auswahl = this.auswahlView.menuAnzeige();

        if (auswahl == 1) {

            this.waehleWare.wareZuWarenkorbHinzufuegen(ware, warenkorb);
            System.out.println(ware + " wurde in den Warenkorb hinzugefuegt");

        } else {
            System.err.println("Bitte etwas korrektes eingeben!");
            this.menueAuswahl(ware, warenkorb);
        }
    }
}
