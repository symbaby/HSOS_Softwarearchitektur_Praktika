package de.hsos.ssa.suchen.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String url = "jdbc:sqlite:C:\\Users\\boery\\source\\repos\\SWA_Praktikum\\01\\Webshop\\src\\main\\java\\de\\hsos\\DB_Shop"; // PC URL
    // TODO: Laptop URL

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
