package com.mr.game.service;

import com.mr.game.model.AnswerStatusEnum;
import com.mr.game.repository.DbRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Component
public class CheckService {

    @Resource
    DbRepository dbRepository;

    @Resource
    AnswerService answerService;

    @Enumerated(EnumType.STRING)
    AnswerStatusEnum answerStatusEnum;

    public String isAnswerCorrect (int gameLvl, String playerSqlQuery){
        String answerSql = answerService.getSqlAnswerByGameLvl(gameLvl);
        boolean isCorrect = dbRepository.isResultSetsIdentical(answerSql,playerSqlQuery);
        if(isCorrect){
            return AnswerStatusEnum.CorrectAnswer.name();
        }
        return AnswerStatusEnum.WrongAnswer.name();
    }
}
