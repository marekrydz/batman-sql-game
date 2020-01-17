package com.mr.game.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DbRepository.class})
public class DbRepositoryTest {
    @Autowired
    private DbRepository dbRepository;

    private String getSpecificFiledFromHqlResult(List<Object> objectList, int rowNumber, int field) {
        Object row[] = (Object[]) objectList.get(rowNumber);
        String fieldValue = (String) row[field];
        return fieldValue;
    }

    @Test
    public void isResultSetsIdentical() {
        //Given
        String sqlQuery1 = "select * from heroes";
        String sqlQuery2 = "select * from heroes where id = 1";
        String sqlQuery3 = "select * from heroes join become_stories bs on heroes.become_story_id = bs.id";

        //When
        boolean result1 = dbRepository.isResultSetsIdentical(sqlQuery1, sqlQuery1);
        boolean result2 = dbRepository.isResultSetsIdentical(sqlQuery1, sqlQuery2);
        boolean result3 = dbRepository.isResultSetsIdentical(sqlQuery3, sqlQuery3);

        //Then
        assertTrue(result1);
        assertFalse(result2);
        assertTrue(result3);
    }

    @Test
    public void getObjectsListUsingHqlQuery() {
        //Given
        String hqlQuery1 = "select h.name, h.realName from Hero h where h.name='Batman'";
        String hqlQuery2 = "select h.name, bs.how, bs.place from Hero h join h.becomeStory bs where h.name='Batman'";
        String hqlQuery3 = "select h.name, h.realName, bs.how, bs.place from Hero h full join h.becomeStory bs";
        String hqlQuery4 = "select h.name, h.realName, w.weaponName, w.characteristic from Hero h  join h.weapons w";
        String hqlQuery5 = "select h.name, h.realName, e.nick, e.enemyRealName from Hero h left join h.enemies e";

        //When
        List<Object> result1 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery1);
        List<Object> result2 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery2);
        List<Object> result3 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery3);
        List<Object> result4 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery4);
        List<Object> result5 = dbRepository.getObjectsListUsingHqlQuery(hqlQuery5);

        //Then
         String filedFromResult1 =  getSpecificFiledFromHqlResult(result1,0,0);
         String filedFromResult3 =  getSpecificFiledFromHqlResult(result3,1,3);
         String filedFromResult5 =  getSpecificFiledFromHqlResult(result5,8,0);

        assertEquals(1, result1.size());
        assertEquals("Batman", filedFromResult1);
        assertEquals(1, result2.size());
        assertEquals(3, result3.size());
        assertEquals("On the Gotham City streets", filedFromResult3);
        assertEquals(4, result4.size());
        assertEquals(9, result5.size());
        assertEquals("Robin", filedFromResult5);
    }
}