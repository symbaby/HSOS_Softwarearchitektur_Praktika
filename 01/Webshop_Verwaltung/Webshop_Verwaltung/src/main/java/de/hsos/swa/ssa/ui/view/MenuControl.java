package de.hsos.swa.ssa.ui.view;

import de.hsos.ssa.katalogverwalten.ui.controller.VerwaltungStartController;

import java.sql.SQLException;

public class MenuControl {
    private MenuView menuView;
    private MenuModel menuModel;
    private VerwaltungStartController verwaltungStartController;

    public MenuControl() {
        this.menuView = new MenuView();
        this.menuModel = new MenuModel();
        this.verwaltungStartController = new VerwaltungStartController();
    }

    public void menueAuswahl() throws SQLException {
        int auswahl = this.menuView.menuAnzeige();

        switch (auswahl) {
            case 1 -> {
                System.out.println("Warensuche wurde in Aufgabe 1.3 implementiert");
            }
            case 2 -> {
                System.err.println("Modul Warenkorb wurde noch nicht implementiert");
            }
            case 3 -> {
                System.err.println("Modul Kasse wurde noch nicht implementiert");
            }

            case 4 -> {
                System.out.println("Katalog verwalten wurde ausgewaehlt");
                this.verwaltungStartController.menueAuswahl();

            }

            default -> {
                System.err.println("Bitte etwas korrektes eingeben!");
                this.menueAuswahl();
            }
        }

    }
}