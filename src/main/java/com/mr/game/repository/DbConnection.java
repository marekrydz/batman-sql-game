package com.mr.game.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class DbConnection {
    public Connection conn = null;
    public Statement getConnectionToDb(String DbURL, String user, String password) {
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(DbURL, user, password);
            statement = Objects.requireNonNull(conn, "Connection  is null").createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
