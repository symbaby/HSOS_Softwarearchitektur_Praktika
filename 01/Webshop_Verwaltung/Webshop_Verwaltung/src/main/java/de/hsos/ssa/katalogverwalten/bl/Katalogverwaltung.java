package de.hsos.ssa.katalogverwalten.bl;

import java.sql.SQLException;

public interface Katalogverwaltung {

    public void create(String name, int preis, String beschreibung) throws SQLException;
    public void update(int nummer, String name, int preis, String beschreibung);

    public void delete(int id);




}
