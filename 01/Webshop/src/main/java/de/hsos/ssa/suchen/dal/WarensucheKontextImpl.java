package de.hsos.ssa.suchen.dal;

import de.hsos.ssa.suchen.bl.Geld;
import de.hsos.ssa.suchen.bl.Produktinformation;
import de.hsos.ssa.suchen.bl.Ware;
import de.hsos.ssa.suchen.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WarensucheKontextImpl implements IWarensuchePerAlgorithmus {

    @Override
    public Ware suche(String suche) throws SQLException {
        return this.get(suche);
    }


    /**
     * Alle Artikel die z.B als Artikelgruppe "Lebensmittel" haben sollten hier zurueckgegeben werden
     * Die Umsetzung der Datenbank erfolgte relativ spaet waehrend der Implementation.
     * Wir haben diese Implementation jetzt dummy maesig so umgesetzt
     */
    public Ware get(String name) throws SQLException {

        Connection con = Database.getConnection();
        Ware ware = null;

        String sql = "SELECT * FROM Ware WHERE name like ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int nummer = rs.getInt("nummer");
            String name_ = rs.getString("name");
            int preis = rs.getInt("preis");
            String beschreibung = rs.getString("beschreibung");

            ware = new Ware.WareBuilder()
                    .warennummerHinzufuegen(nummer)
                    .nameHinzufuegen(name)
                    .beschreibung(beschreibung)
                    .preisHinzufuegen(new Geld(preis, "EURO"))
                    .produktInformationHinzufuegen(new Produktinformation(beschreibung, name))
                    .build();
        }

        return ware;
    }
}
