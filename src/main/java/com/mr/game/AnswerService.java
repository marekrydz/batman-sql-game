package com.mr.game;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AnswerService {

    @Resource
    private AnswerRepository answerRepository;

    public String getAnswer(int gameLvl) {
        return answerRepository.getAnswerByGameLvl(gameLvl).getAnswerSql();
    }
}

