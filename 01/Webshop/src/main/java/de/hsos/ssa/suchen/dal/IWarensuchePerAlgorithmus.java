package de.hsos.ssa.suchen.dal;

import de.hsos.ssa.suchen.bl.Ware;

import java.sql.SQLException;

public interface IWarensuchePerAlgorithmus {
     Ware suche(String suche) throws SQLException;
}
