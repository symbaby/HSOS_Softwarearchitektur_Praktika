package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.bl.Ware;

import java.sql.SQLException;

public interface ISucheWare {
    Ware sucheWare(String warenname) throws SQLException;
    Ware sucheWare(int warennummer) throws SQLException;
}
