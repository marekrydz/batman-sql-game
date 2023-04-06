package com.mr.game.service;


import com.mr.game.repository.AnswerRepository;
import com.mr.game.repository.DbRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final DbRepository dbRepository;

    public AnswerService(AnswerRepository answerRepository, DbRepository dbRepository) {
        this.answerRepository = answerRepository;
        this.dbRepository = dbRepository;
    }

    public String getSqlAnswerByGameLvl(String gameLvl) {
        return answerRepository.getAnswerByGameLvl(gameLvl).getAnswerSql();
    }

    public List<Object> getCorrectAnswer(String gameLvl) {
        String hqlQuery = answerRepository.getHqlQueryByGameLvl(gameLvl);
        return dbRepository.getObjectsListUsingHqlQuery(hqlQuery);
    }
}

