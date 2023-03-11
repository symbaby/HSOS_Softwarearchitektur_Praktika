package de.hsos.ssa.katalogverwalten.al;

import de.hsos.ssa.katalogverwalten.bl.Katalogverwaltung;
import de.hsos.ssa.katalogverwalten.ui.controller.UpdateControl;

import java.sql.SQLException;

public class UpdateInModul {
    private Katalogverwaltung katalogverwaltung;

    public UpdateInModul(Katalogverwaltung katalogverwaltung){
        this.katalogverwaltung = katalogverwaltung;
    }

    public void updateUpdate(int nummer, String name, int preis, String beschreibung){
        this.katalogverwaltung.update(nummer, name, preis, beschreibung);
    }

    public void createUpdate(String name, int preis, String beschreibung) throws SQLException {
        this.katalogverwaltung.create(name,preis,beschreibung);

    }


    public void deleteUpdate(int id){
        this.katalogverwaltung.delete(id);
    }

}
