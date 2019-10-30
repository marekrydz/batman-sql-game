package hello;

import com.google.common.collect.Multimap;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Check {

    @Resource
    DbRepository dbRepository;

    @Resource
    AnswerService answerService;

    boolean isCorrectAnswer(int gameLvl, String playerSql) {
        String correctSql = answerService.getAnswer(gameLvl);
        Multimap correctAnswer = dbRepository.getSqlQueryResultFromDBToMultimap(correctSql);
        Multimap playerAnswer = dbRepository.getSqlQueryResultFromDBToMultimap(playerSql);

        if (correctAnswer.equals(playerAnswer)) {
            return true;
        }

        return false;
    }

}
