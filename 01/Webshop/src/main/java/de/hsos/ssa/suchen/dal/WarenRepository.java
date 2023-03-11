package de.hsos.ssa.suchen.dal;

import de.hsos.ssa.suchen.bl.IKatalog;
import de.hsos.ssa.suchen.bl.Suchverfahren;
import de.hsos.ssa.suchen.bl.Ware;

import java.sql.SQLException;

public class WarenRepository implements IKatalog {

    private IWarensuchePerAlgorithmus warensuchePerAlgorithmus = new WarensucheWortgruppeImpl();
    private IWarensuche warensuche;

    public WarenRepository() {
        this.warensuche = new WarensucheNummerImpl();
    }

    @Override
    public void legeSuchverfahrenFest(Suchverfahren suchverfahren) {
        if (suchverfahren == Suchverfahren.KONTEXT) {
            this.warensuchePerAlgorithmus = new WarensucheKontextImpl();

        } else if (suchverfahren == Suchverfahren.WORTGRUPPE) {
            this.warensuchePerAlgorithmus = new WarensucheWortgruppeImpl();
        }
    }

    @Override
    public Ware suchen(String warenname) throws SQLException {
        return this.warensuchePerAlgorithmus.suche(warenname);
    }

    @Override
    public Ware suchen(int warennummer) throws SQLException {
        return this.warensuche.suche(warennummer);
    }

    @Override
    public void gebeProduktinformationen(Ware ware) {
        System.out.println(ware.getProduktinformation());
    }
}
