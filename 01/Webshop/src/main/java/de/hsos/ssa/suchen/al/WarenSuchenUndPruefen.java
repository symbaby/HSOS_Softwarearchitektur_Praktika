package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.bl.IKatalog;
import de.hsos.ssa.suchen.bl.Suchverfahren;
import de.hsos.ssa.suchen.bl.Ware;

import java.sql.SQLException;

public class WarenSuchenUndPruefen {

    private IKatalog katalog;

    public WarenSuchenUndPruefen(IKatalog repository) {
        this.katalog = repository;
    }

    public void legeSuchverfahrenFest(Suchverfahren suchverfahren) {
        this.katalog.legeSuchverfahrenFest(suchverfahren);
    }


    public Ware suchen(String warenname) throws SQLException {
        return this.katalog.suchen(warenname);
    }


    public Ware suchen(int warennummer) throws SQLException {
        return this.katalog.suchen(warennummer);
    }


    public void gebeProduktinformationen(Ware ware) {
        this.katalog.gebeProduktinformationen(ware);
    }
}
