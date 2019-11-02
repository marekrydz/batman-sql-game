package com.mr.game.service;

import com.google.common.collect.Multimap;
import com.mr.game.model.AnswerEnum;
import com.mr.game.repository.DbRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Component
public class Check {

    @Resource
    DbRepository dbRepository;

    @Resource
    AnswerService answerService;

    @Enumerated(EnumType.STRING)
    AnswerEnum answerEnum;

    public String isCorrectAnswer(int gameLvl, String playerSql) {
        String correctSql = answerService.getAnswerByGameLvl(gameLvl);
        Multimap correctAnswer = dbRepository.getSqlQueryResultFromDBToMultimap(correctSql);
        Multimap playerAnswer = dbRepository.getSqlQueryResultFromDBToMultimap(playerSql);

        if (correctAnswer.equals(playerAnswer)) {
            return AnswerEnum.Correct.name();
        }
        if (!correctAnswer.equals(playerAnswer)) {
            return AnswerEnum.Wrong.name();
        }
        return AnswerEnum.Neutral.name();

    }

}
