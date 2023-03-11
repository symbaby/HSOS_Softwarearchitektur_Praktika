package de.hsos.ssa.suchen.ui.controller;

import de.hsos.ssa.suchen.acl.IWarenkorbFuerSuche;
import de.hsos.ssa.suchen.acl.Warenkorb;
import de.hsos.ssa.suchen.al.Einkaeufer;
import de.hsos.ssa.suchen.al.HoleWarenkorbImpl;
import de.hsos.ssa.suchen.ui.model.SuchenStartModel;
import de.hsos.ssa.suchen.ui.view.SuchenStartView;
import de.hsos.ssa.suchen.al.IHoleWarenkorb;
import de.hsos.ssa.suchen.al.SucheWareImpl;

import java.sql.SQLException;


public class SuchenStartControl {
    private SuchenStartModel suchenStartModel;
    private SuchenStartView suchenStartView;
    private SuchControl suchControl;

    private IHoleWarenkorb holeWarenkorb;

    private IWarenkorbFuerSuche warenkorb;

    public SuchenStartControl(IHoleWarenkorb holeWarenkorb) {
        this.suchenStartModel = new SuchenStartModel();
        this.suchenStartView = new SuchenStartView();

        this.suchControl = new SuchControl(new Einkaeufer());
        this.holeWarenkorb = holeWarenkorb;
    }

    /**
     * MenueAuswahl der SuchenStartControll.
     * Der Benutzer muss bevor er sein Warenkorb verwalten kann, sich diesen holen.
     * Nachdem der Nutzer den Warenkorb hat, kann er im Warenkorb suchen, pruefen, oder auswaehlen!
     */
    public void menueAuswahl() throws SQLException {
        int input = this.suchenStartView.menuAnzeige();
        if (input == 1) {

            int warenKorbAuswahlOption = this.suchenStartView.holeWarenkorbAuswahl();

            if (warenKorbAuswahlOption == 1) {
                int warenkorbnummer = this.suchenStartView.auswahlWarenkorbnummer();
                warenkorb = this.holeWarenkorb.holeWarenkorb(warenkorbnummer);
                this.suchControl.setzeWarenkorb(warenkorb);
                this.suchControl.menueAuswahl();

            } else if (warenKorbAuswahlOption == 2) {
                warenkorb = this.holeWarenkorb.holeWarenkorb();
                this.suchControl.setzeWarenkorb(warenkorb);
                this.suchControl.menueAuswahl();
            } else {
                System.err.println("Bitte etwas richtiges eingeben!");
                this.menueAuswahl();
            }

        } else {
            System.err.println("Hole zuerst deinen Warenkorb!");
            this.menueAuswahl();
        }
    }


}
