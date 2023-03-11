package de.hsos.swa.ssa.ui.view;

import de.hsos.ssa.suchen.al.Einkaeufer;
import de.hsos.ssa.suchen.ui.controller.SuchenStartControl;
import de.hsos.ssa.suchen.al.HoleWarenkorbImpl;

import java.sql.SQLException;

public class MenuControl {
    private MenuView menuView;
    private MenuModel menuModel;
    private SuchenStartControl suchenStartControl;

    public MenuControl() {
        this.menuView = new MenuView();
        this.menuModel = new MenuModel();

        this.suchenStartControl = new SuchenStartControl(new Einkaeufer());
    }

    public void menueAuswahl() throws SQLException {
        int auswahl = this.menuView.menuAnzeige();

        switch (auswahl) {
            case 1 -> {
                System.out.println("Warensuche ausgewaehlt");
                this.suchenStartControl.menueAuswahl();
            }
            case 2 -> {
                System.err.println("Model Warenkorb wurde noch nicht implementiert");
            }
            case 3 -> {
                System.err.println("Model Kasse wurde noch nicht implementiert");
            }

            default -> {
                System.err.println("Bitte etwas korrektes eingeben!");
                this.menueAuswahl();
            }
        }

    }
}
