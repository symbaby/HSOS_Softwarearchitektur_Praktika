package de.hsos.ssa.katalogverwalten.dal;

import de.hsos.ssa.katalogverwalten.bl.Katalogverwaltung;

import java.sql.SQLException;

public class KatalogRepository implements Katalogverwaltung {
    private IAusfuehrung ausfuehrung;

    public KatalogRepository() {
        this.ausfuehrung = new AusfuehrungImpl();
    }

    @Override
    public void create(String name, int preis, String beschreibung) throws SQLException {
        this.ausfuehrung.create(name,preis,beschreibung);
    }

    @Override
    public void update(int nummer, String name, int preis, String beschreibung) {
        this.ausfuehrung.update(nummer, name, preis, beschreibung);
    }

    @Override
    public void delete(int id) {
        this.ausfuehrung.delete(id);
    }
}
