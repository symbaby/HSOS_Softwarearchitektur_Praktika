package de.hsos.ssa.katalogverwalten.ui.controller;


import de.hsos.ssa.katalogverwalten.al.Admin;
import de.hsos.ssa.katalogverwalten.ui.model.VerwaltungStartModel;
import de.hsos.ssa.katalogverwalten.ui.view.VerwaltungStartView;

import java.sql.SQLException;

public class VerwaltungStartController {
    private VerwaltungStartModel verwaltungStartModel;
    private VerwaltungStartView verwaltungStartView;
    private CreateControl createControl;
    private DeleteControl deleteControl;
    private UpdateControl updateControl;

    public VerwaltungStartController() {
        this.verwaltungStartModel = new VerwaltungStartModel();
        this.verwaltungStartView = new VerwaltungStartView();
        this.createControl = new CreateControl(new Admin());
        this.deleteControl = new DeleteControl(new Admin());
        this.updateControl = new UpdateControl(new Admin());
    }

    public void menueAuswahl() throws SQLException {
        int input = 0;
        while (input != -1) {
            input = this.verwaltungStartView.menueAnzeigen();

            switch (input) {
                case 1 -> {
                    System.out.println("Create Option");
                    this.createControl.menueAuswahl();
                }

                case 2 -> {
                    System.out.println("Update Option");
                    this.updateControl.menueAnzeige();
                }

                case 3 -> {
                    System.out.println("Delete Option");
                    this.deleteControl.menueAnzeige();
                }

                case -1 -> {
                    System.out.println("Programm wurde beendet");
                }

                default -> {
                    System.err.println("Gib was richtiges ein!");
                }
            }
        }


    }
}
