package com.mr.game.repository;

import com.mr.game.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer getAnswerByGameLvl(String gameLvl);

    @Query(value = "select answer_hql from answers where game_lvl=?1", nativeQuery = true)
    String getHqlQueryByGameLvl(String gameLvl);
}
