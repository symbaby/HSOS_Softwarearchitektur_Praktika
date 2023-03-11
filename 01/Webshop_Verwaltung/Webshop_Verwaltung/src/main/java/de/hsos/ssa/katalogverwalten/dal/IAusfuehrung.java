package de.hsos.ssa.katalogverwalten.dal;

import java.sql.SQLException;

public interface IAusfuehrung {
    public void create(String name, int preis, String beschreibung) throws SQLException;

    public void update(int nummer, String name, int preis, String beschreibung);

    public void delete(int id);
}
