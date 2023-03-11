package de.hsos.ssa.suchen.bl;

import java.sql.SQLException;

public interface IKatalog {
    void legeSuchverfahrenFest(Suchverfahren suchverfahren);
    Ware suchen(String warenname) throws SQLException;
    Ware suchen(int warennummer) throws SQLException;
    void gebeProduktinformationen(Ware ware);
}
