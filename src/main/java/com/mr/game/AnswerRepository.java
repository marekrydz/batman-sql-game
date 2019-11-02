package com.mr.game;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer getAnswerByGameLvl(int gameLvl);
}
