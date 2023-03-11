package de.hsos.ssa.katalogverwalten.dal;

import de.hsos.ssa.katalogverwalten.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AusfuehrungImpl implements IAusfuehrung {

    @Override
    public void create(String name_, int preis_, String beschreibung_) throws SQLException {

        String sql = "INSERT INTO Ware (name, preis, beschreibung) VALUES (?, ?, ?)";

        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, name_);
            pstmt.setInt(2, preis_);
            pstmt.setString(3, beschreibung_);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int nummer_, String name_, int preis_, String beschreibung_) {

        String sql = "UPDATE Ware SET name = ?, preis = ?, beschreibung = ? WHERE nummer = ?;";

        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, name_);
            pstmt.setInt(2, preis_);
            pstmt.setString(3, beschreibung_);
            pstmt.setInt(4, nummer_);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {

        String sql = "DELETE FROM Ware where nummer = ?";

        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
