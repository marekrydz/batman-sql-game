package com.mr.game.repository;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.mr.game.configuration.ConfigurationDB;

@Component
public class DbRepository {

    private DbConnection dbConnection = new DbConnection();
    public int numberOfRowsFromDB = 0;
    private String url;
    private String password;
    private String username;

    public DbRepository(@Value("${spring.datasource.url}")String url,@Value("${spring.datasource.password}") String password,  @Value("${spring.datasource.username}")String username) {
        this.url = url;
        this.password = password;
        this.username = username;
    }

    public Multimap getSqlQueryResultFromDBToMultimap(String sqlQuery) {
        ResultSet rs;
        Multimap<String, String> multiMap = ArrayListMultimap.create();

        try {
            Statement stmt = dbConnection.connectToPostgreSQL(url, username, password);
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