package de.hsos.ssa.suchen.al;

import de.hsos.ssa.suchen.bl.Ware;
import de.hsos.ssa.suchen.dal.WarenRepository;

import java.sql.SQLException;

public class SucheWareImpl implements ISucheWare {

    private WarenSuchenUndPruefen warenSuchenUndPruefen;

    public SucheWareImpl() {
        this.warenSuchenUndPruefen = new WarenSuchenUndPruefen(new WarenRepository());
    }

    @Override
    public Ware sucheWare(String warenname) throws SQLException {

        return this.warenSuchenUndPruefen.suchen(warenname);
    }

    @Override
    public Ware sucheWare(int warennummer) throws SQLException {


        return this.warenSuchenUndPruefen.suchen(warennummer);

    }
}
