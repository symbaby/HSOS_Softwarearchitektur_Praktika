package de.hsos.ssa.suchen.ui.controller;

import de.hsos.ssa.suchen.bl.Geld;
import de.hsos.ssa.suchen.bl.Produktinformation;
import de.hsos.ssa.suchen.bl.Ware;
import de.hsos.ssa.suchen.ui.model.PruefModel;
import de.hsos.ssa.suchen.ui.view.PruefView;
import de.hsos.ssa.suchen.al.IPruefeWare;


public class PruefControl {
    private PruefModel pruefModel;
    private PruefView pruefView;
    private IPruefeWare pruefeWare;

    public PruefControl(IPruefeWare pruefeWare) {
        this.pruefModel = new PruefModel();
        this.pruefView = new PruefView();
        this.pruefeWare = pruefeWare;
    }

    public void holeDetailinformationenVonWare(Ware w) {
        int auswahl = this.pruefView.menuAnzeige();

        if (auswahl == 1) {

            this.pruefeWare.holeDetailinformationen(w);
            System.out.println(w);

        } else {
            System.err.println("Bitte etwas korrektes eingeben!");
            this.holeDetailinformationenVonWare(w);
        }
    }
}
