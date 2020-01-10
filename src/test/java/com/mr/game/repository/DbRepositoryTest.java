package com.mr.game.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
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
}