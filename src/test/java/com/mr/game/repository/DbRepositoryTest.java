package com.mr.game.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(classes = {DbRepository.class})
public class DbRepositoryTest {
    @Autowired
    private DbRepository dbRepository;

    @Test
    public void isResultSetsIdentical() {
        //Given
        String sqlQuery1 = "select * from heroes";
        String sqlQuery2 = "select * from heroes where id = 1";
        String sqlQuery3 = "select * from heroes join become_stories bs on heroes.become_story_id = bs.id";

        //When
        boolean result1 = dbRepository.isResultSetsIdentical(sqlQuery1,sqlQuery1);
        boolean result2 = dbRepository.isResultSetsIdentical(sqlQuery1,sqlQuery2);
        boolean result3 = dbRepository.isResultSetsIdentical(sqlQuery3,sqlQuery3);

        //Then
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
    }

    @Test
    public void getObjectsListUsingHqlQuery() {
        String hqlQuery1 = "select h.name, h.realName from Hero h where h.name='Batman'";
//        select h.name, bs.how, bs.place from heroes as h
//join become_stories bs on h.become_story_id = bs.id
//where h.name= 'Batman
        String hqlQuery2 = "select h.name, bs.how, bs.place from Hero h join h.becomeStory bs where h.name='Batman'";

//        Select * from heroes
//full join  become_stories on heroes.become_story_id= become_stories.id
        String hqlQuery3 = "select h.name, h.realName, bs.how, bs.place from Hero h full join h.becomeStory bs";
//select * from heroes as h join weapons w on h.id = w.hero_id
        String hqlQuery4 = "select h.name, h.realName, w.weaponName, w.characteristic from Hero h  join h.weapons w";
        String hqlQuery5 = "select h.name, h.realName, e.nick, e.enemyRealName from Hero h left join h.enemies e";

        List<Object> result1 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery1);
        List<Object> result2 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery2);
        List<Object> result3 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery3);
        List<Object> result4 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery4);
        List<Object> result5 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery5);

        Iterator it=result5.iterator();
        while(it.hasNext())
        {
            Object rows[] = (Object[])it.next();
            System.out.println(rows[0]+ " -- " +rows[1]+" -- " +rows[2]+" -- " +rows[3]);
        }
    }
}