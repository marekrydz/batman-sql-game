package com.mr.game.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class DbRepository {

    private DbConnection dbConnection = new DbConnection();

    public boolean isResultOfSqlQueriesIdentical(String firstSqlQuery, String secondSqlQuery) {
        Statement stmt = dbConnection.getConnectionToDb("jdbc:postgresql://localhost:5432/postgres", "postgres", "marek");
        ResultSet resultSet;
        boolean isIdentical = false;
        try {
            String queryToExecute = firstSqlQuery + " except " + secondSqlQuery;
            resultSet = stmt.executeQuery(queryToExecute);
            isIdentical = !resultSet.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isIdentical;
    }

    public List<Object> getObjectsListUsingHqlQuery(String hqlQuery){
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query qry= session.createQuery(hqlQuery);
        return qry.list();
    }
}