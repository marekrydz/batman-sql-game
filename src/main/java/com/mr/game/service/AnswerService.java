package com.mr.game.service;


import com.mr.game.repository.AnswerRepository;
import com.mr.game.repository.DbRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswerService {

    @Resource
    private AnswerRepository answerRepository;

    @Resource
    DbRepository dbRepository;

    public String getSqlAnswerByGameLvl(String gameLvl) {
        return answerRepository.getAnswerByGameLvl(gameLvl).getAnswerSql();
    }

    public List<Object> getCorrectAnswer(String gameLvl) {
        String hqlQuery = answerRepository.getHqlQueryByGameLvl(gameLvl);
        List<Object> result = dbRepository.getObjectsListUsingHqlQuery(hqlQuery);
        return result;
    }
}

