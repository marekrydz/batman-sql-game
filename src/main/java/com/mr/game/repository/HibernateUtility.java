package com.mr.game.repository;

import com.mr.game.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static SessionFactory factory;

    private HibernateUtility() {
    }

    public synchronized static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory= new Configuration()
                    .addAnnotatedClass(Hero.class)
                    .addAnnotatedClass(Weapon.class)
                    .addAnnotatedClass(BecomeStory.class)
                    .addAnnotatedClass(Enemy.class)
                    .addAnnotatedClass(Answer.class)
                    .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres")
                    .setProperty("hibernate.connection.username", "postgres")
                    .setProperty("hibernate.connection.password", "marek")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect")
                    .setProperty("hibernate.current_session_context_class", "thread")
                    .setProperty("hibernate.jdbc.lob.non_contextual_creation", "true")
                    .buildSessionFactory();
        }
        return factory;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new RuntimeException("Clone not Supported");
    }
}
