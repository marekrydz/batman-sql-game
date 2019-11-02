package com.mr.game.service;


import com.mr.game.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AnswerService {

    @Resource
    private AnswerRepository answerRepository;

    public String getAnswerByGameLvl(int gameLvl) {
        return answerRepository.getAnswerByGameLvl(gameLvl).getAnswerSql();
    }
}

