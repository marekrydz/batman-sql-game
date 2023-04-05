package com.mr.game.controller;

import com.mr.game.model.AnswerStatusEnum;
import com.mr.game.model.LevelDescription;
import com.mr.game.service.AnswerService;
import com.mr.game.service.CheckService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GameController {

    private final CheckService checkService;
    private final LevelDescription levelDescription;
    private String info;
    private String mission;
    private String tableDescription;

    private final AnswerService answerService;

    public GameController(CheckService checkService, LevelDescription levelDescription, AnswerService answerService) {
        this.checkService = checkService;
        this.levelDescription = levelDescription;
        this.answerService = answerService;
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome-screen";
    }

    @GetMapping("/instruction")
    public String getInstruction() {
        return "instruction";
    }

    @PostMapping("/instruction")
    public String postInstruction() {
        return "instruction";
    }

    @GetMapping({ "/lvl-1.0", "/lvl-1.1", "/lvl-1.2", "/lvl-1.3", "/lvl-1.4", "/lvl-2.0", "/lvl-2.1", "/lvl-3.0",
            "/lvl-4.0" })
    public String getLevel(Model model, HttpServletRequest request) {
        String level = request.getServletPath().substring(5);
        model.addAttribute("info", levelDescription.getInfo(level));
        model.addAttribute("mission", levelDescription.getMission(level));
        model.addAttribute("tableDescription", levelDescription.getHeroTable());
        model.addAttribute("answerStatus", AnswerStatusEnum.NEUTRAL.name());
        return "lvl-" + level;
    }

    @PostMapping({ "/lvl-1.0", "/lvl-1.1", "/lvl-1.2", "/lvl-1.3", "/lvl-1.4", "/lvl-2.0", "/lvl-2.1", "/lvl-3.0",
            "/lvl-4.0" })
    public String postLevel(Model model, @RequestParam String sqlQuery, HttpServletRequest request) {
        String level = request.getServletPath().substring(5);
        String answerStatus = checkService.isAnswerCorrect(level, sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (AnswerStatusEnum.CORRECT_ANSWER.name().equals(answerStatus)) {
            answerList = answerService.getCorrectAnswer(level);
        }
        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-" + level;
    }

    @GetMapping("/game-finished")
    public String gameFinished(Model model) {

        return "game-finished";
    }

}
