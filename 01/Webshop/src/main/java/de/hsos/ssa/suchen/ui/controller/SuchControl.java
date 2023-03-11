package de.hsos.ssa.suchen.ui.controller;

import de.hsos.ssa.suchen.acl.IWarenkorbFuerSuche;
import de.hsos.ssa.suchen.acl.Warenkorb;
import de.hsos.ssa.suchen.al.Einkaeufer;
import de.hsos.ssa.suchen.bl.Ware;
import de.hsos.ssa.suchen.ui.model.SuchModel;
import de.hsos.ssa.suchen.ui.view.SuchView;

import de.hsos.ssa.suchen.al.PruefeWareImpl;
import de.hsos.ssa.suchen.al.ISucheWare;
import de.hsos.ssa.suchen.al.WaehleWareImpl;

import java.sql.SQLException;


public class SuchControl {
    private SuchModel suchModel;
    private SuchView suchView;

    private PruefControl pruefControl;
    private AuswahlControl auswahlControl;

    private ISucheWare sucheWare;
    private IWarenkorbFuerSuche warenkorb;

    private Ware aktuelleWare;


    public SuchControl(ISucheWare sucheWare) {
        this.suchModel = new SuchModel();
        this.suchView = new SuchView();
        this.pruefControl = new PruefControl(new Einkaeufer());
        this.auswahlControl = new AuswahlControl(new Einkaeufer());
        this.sucheWare = sucheWare;

    }

    public void menueAuswahl() throws SQLException {

        int auswahlOption = this.suchView.holeAuswahloption();

        if (auswahlOption == 1) {
            String warenname = this.suchView.auswahlWarenname();
            this.aktuelleWare = this.sucheWare.sucheWare(warenname);
        } else if (auswahlOption == 2) {
            int warennummer = this.suchView.auswahlWarennummer();
            this.aktuelleWare = this.sucheWare.sucheWare(warennummer);
        }

        if (aktuelleWare != null) {
            int auswahl = 0;
            while (auswahl != -1) {
                auswahl = this.suchView.auswahlPruefenOderWarenkorbLegen();
                switch (auswahl) {
                    case 1 -> {
                        this.pruefControl.holeDetailinformationenVonWare(this.aktuelleWare);
                    }

                    case 2 -> {
                        this.auswahlControl.menueAuswahl(this.aktuelleWare, this.warenkorb);
                    }

                    default -> {
                        System.err.println("Ende");
                    }
                }
            }

        } else {
            System.err.println("Artikel nicht gefunden... versuch es nochmal mit einem gueltigen Artikel");
            this.menueAuswahl();
        }


    }


    public void setzeWarenkorb(IWarenkorbFuerSuche warenkorb) {
        this.warenkorb = warenkorb;
    }


}
