package com.mr.game.repository;

import com.mr.game.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtility {

    private SessionFactory factory;

    @Value("${spring.datasource.url}")
    String dbUrl;
    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;


    public  SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration()
                    .addAnnotatedClass(Hero.class)
                    .addAnnotatedClass(Weapon.class)
                    .addAnnotatedClass(BecomeStory.class)
                    .addAnnotatedClass(Enemy.class)
                    .addAnnotatedClass(Answer.class)
                    .setProperty("hibernate.connection.url", dbUrl)
                    .setProperty("hibernate.connection.username", userName)
                    .setProperty("hibernate.connection.password", password)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect")
                    .setProperty("hibernate.current_session_context_class", "thread")
                    .setProperty("hibernate.jdbc.lob.non_contextual_creation", "true")
                    .buildSessionFactory();
        }
        return factory;
    }

}
