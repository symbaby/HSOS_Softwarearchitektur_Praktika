package de.hsos.ssa.suchen.dal;

import de.hsos.ssa.suchen.bl.Ware;

import java.sql.SQLException;

public interface IWarensuche {
    Ware suche(int nummer) throws SQLException;
}
