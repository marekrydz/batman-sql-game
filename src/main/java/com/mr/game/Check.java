package com.mr.game;

import com.google.common.collect.Multimap;
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

    String isCorrectAnswer(int gameLvl, String playerSql) {
        String correctSql = answerService.getAnswer(gameLvl);
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
