package com.mr.game.repository;

import com.mr.game.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.Resource;

@Resource
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer getAnswerByGameLvl(int gameLvl);

    @Query(value = "select answer_hql from answers where id =?1", nativeQuery = true)
    String getHqlQueryFromGameLvl(int gameLvl);
}
