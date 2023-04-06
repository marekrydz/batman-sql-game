package com.mr.game.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class DbRepository {

    HibernateUtility hibernateUtility;
    private final String dbUrl;
    private final String userName;
    private final String password;

    public DbRepository(HibernateUtility hibernateUtility, @Value("${spring.datasource.url}") String dbUrl,
                        @Value("${spring.datasource.username}") String userName,
                        @Value("${spring.datasource.password}") String password) {
        this.hibernateUtility = hibernateUtility;
        this.dbUrl = dbUrl;
        this.userName = userName;
        this.password = password;
    }

    public boolean isResultOfSqlQueriesIdentical(String firstSqlQuery, String secondSqlQuery) {
        boolean isIdentical = false;
        ResultSet resultSet1;
        ResultSet resultSet2;
        boolean isIdentical1;
        boolean isIdentical2;
        try (Connection conn = DriverManager.getConnection(dbUrl, userName, password);
             Statement stmt = conn.createStatement()) {

            String queryToExecute = secondSqlQuery + " except " + firstSqlQuery;
            String queryToExecute2 = firstSqlQuery + " except " + secondSqlQuery;

            resultSet1 = stmt.executeQuery(queryToExecute);
            isIdentical1 = !resultSet1.isBeforeFirst();

            resultSet2 = stmt.executeQuery(queryToExecute2);
            isIdentical2 = !resultSet2.isBeforeFirst();

            if (isIdentical1 && isIdentical2) {
                isIdentical = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isIdentical;
    }

    public List<Object> getObjectsListUsingHqlQuery(String hqlQuery) {
        SessionFactory sessionFactory = hibernateUtility.getSessionFactory();
        Query qry;
        try (Session session = sessionFactory.openSession()) {
            qry = session.createQuery(hqlQuery);
            return qry.list();
        }
    }
}