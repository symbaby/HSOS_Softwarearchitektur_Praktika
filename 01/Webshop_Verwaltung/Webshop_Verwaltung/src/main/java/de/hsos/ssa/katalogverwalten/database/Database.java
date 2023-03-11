package de.hsos.ssa.katalogverwalten.database;

import java.sql.*;

public class Database {
    private static String url = "jdbc:sqlite:C:\\Users\\boery\\source\\repos\\SWA_Praktikum\\01\\Webshop_Verwaltung\\Webshop_Verwaltung\\src\\main\\java\\de\\hsos\\DB_Verwaltung"; // PC URL
    // TODO: Laptop URL

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }
}
