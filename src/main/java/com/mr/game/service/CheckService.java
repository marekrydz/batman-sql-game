package com.mr.game.service;
import com.mr.game.model.AnswerStatusEnum;
import com.mr.game.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CheckService {
    private final DbRepository dbRepository;
    private final AnswerService answerService;
    @Autowired
    public CheckService(DbRepository dbRepository, AnswerService answerService) {
        this.dbRepository = dbRepository;
        this.answerService = answerService;
    }
    public String isAnswerCorrect(String gameLevel, String playerSqlQuery) {
        String answerSql = answerService.getSqlAnswerByGameLvl(gameLevel);
        boolean isCorrect = dbRepository.isResultOfSqlQueriesIdentical(playerSqlQuery, answerSql);
        return isCorrect ? AnswerStatusEnum.CORRECT_ANSWER.name() : AnswerStatusEnum.WRONG_ANSWER.name();
    }
}