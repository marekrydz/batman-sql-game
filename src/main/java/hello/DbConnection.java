package hello;


import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.sql.*;

@Repository
public class DbConnection {
    Connection conn = null;
    public Statement connectToPostgreSQL(String DbURL, String user, String password) {
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
