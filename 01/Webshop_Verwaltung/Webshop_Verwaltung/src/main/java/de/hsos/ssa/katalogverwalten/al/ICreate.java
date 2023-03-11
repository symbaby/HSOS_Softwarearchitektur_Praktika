package de.hsos.ssa.katalogverwalten.al;

import java.sql.SQLException;

public interface ICreate {
    public void create(String name, int preis, String beschreibung) throws SQLException;
}
