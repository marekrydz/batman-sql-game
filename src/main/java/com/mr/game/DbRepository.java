package com.mr.game;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbRepository {

    private DbConnection dbConnection = new DbConnection();
    int numberOfRowsFromDB = 0;

    Multimap getSqlQueryResultFromDBToMultimap(String sqlQuery) {
        ResultSet rs;

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "marek";
        Multimap<String, String> multiMap = ArrayListMultimap.create();

        try {
            Statement stmt = dbConnection.connectToPostgreSQL(url, user, password);
            rs = stmt.executeQuery(sqlQuery);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            List<String> columnNamesList = new ArrayList<>();
            for (int i = 1; i < columnCount + 1; i++) {
                columnNamesList.add(resultSetMetaData.getColumnName(i));
            }
            while (rs.next()) {
                numberOfRowsFromDB++;
                for (String columnName : columnNamesList) {
                    multiMap.put(columnName, rs.getString(columnName));
                }
            }

            dbConnection.conn.close();

        } catch (
                SQLException e) {
            System.out.println("Empty sql query to DB");
            e.printStackTrace();
        }
        return multiMap;
    }
}