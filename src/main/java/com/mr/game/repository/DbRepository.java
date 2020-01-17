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

    private SessionFactory sessionFactory;
    private DbConnection dbConnection = new DbConnection();

    public boolean isResultSetsIdentical(String firstSqlQuery, String secondSqlQuery) {
        Statement stmt = dbConnection.getConnectionToDb("jdbc:postgresql://localhost:5432/postgres", "postgres", "marek");
        ResultSet resultSet;
        boolean isIdentical = false;
        try {
            resultSet = stmt.executeQuery( firstSqlQuery + " except " + secondSqlQuery);
            isIdentical = !resultSet.isBeforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isIdentical;
    }

    public List<Object> getObjectsListUsingHqlQuery(String hqlQuery){
        sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query qry= session.createQuery(hqlQuery);
        List result = qry.list();
        return result;
    }
}