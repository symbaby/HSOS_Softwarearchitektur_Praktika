package de.hsos.ssa.suchen.dal;

import de.hsos.ssa.suchen.bl.Geld;
import de.hsos.ssa.suchen.bl.Produktinformation;
import de.hsos.ssa.suchen.bl.Ware;
import de.hsos.ssa.suchen.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WarensucheNummerImpl implements IWarensuche{

    @Override
    public Ware suche(int nummer) throws SQLException {

        return this.get(nummer);
    }

    public Ware get(int nummer) throws SQLException {

        Connection con = Database.getConnection();
        Ware ware = null;

        String sql = "SELECT * FROM Ware WHERE nummer = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, nummer);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int nummer_ = rs.getInt("nummer");
            String name_ = rs.getString("name");
            int preis = rs.getInt("preis");
            String beschreibung = rs.getString("beschreibung");

            ware = new Ware.WareBuilder()
                    .warennummerHinzufuegen(nummer)
                    .nameHinzufuegen(name_)
                    .beschreibung(beschreibung)
                    .preisHinzufuegen(new Geld(preis, "EURO"))
                    .produktInformationHinzufuegen(new Produktinformation(beschreibung, name_))
                    .build();
        }

        return ware;
    }

}
