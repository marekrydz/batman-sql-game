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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    @Resource
    CheckService checkService;

    @Resource
    LevelDescription levelDescription;

    private String answerStatus;
    private String info;
    private String mission;
    private String tableDescription;

    @Resource
    AnswerService answerService;

    @GetMapping("/")
    public String welcome() {
        return "welcome-screen";
    }

    @PostMapping("/instruction")
    public String postInstruction() {
        return "instruction";
    }

    @GetMapping("/instruction")
    public String getInstruction() {
        return "instruction";
    }

    @GetMapping("/lvl-1.0")
    public String getLvl1(Model model) {
        info = levelDescription.getInfo1x0();
        mission = levelDescription.getMission1x0();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-1.0";
    }

    @PostMapping("/lvl-1.0")
    public String postLvl1(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.0", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.0");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-1.0";
    }

    @GetMapping("/lvl-1.1")
    public String getLvl11(Model model) {
        info = levelDescription.getInfo1x1();
        mission = levelDescription.getMission1x1();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", "Neutral");
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-1.1";
    }

    @PostMapping("/lvl-1.1")
    public String postLvl11(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.1", sqlQuery);
        List<Object> answerList = null;
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.1");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-1.1";
    }

    @GetMapping("/lvl-1.2")
    public String getLvl12(Model model) {
        info = levelDescription.getInfo1x2();
        mission = levelDescription.getMission1x2();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-1.2";
    }

    @PostMapping("/lvl-1.2")
    public String postLvl12(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.2", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.2");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-1.2";
    }

    @GetMapping("/lvl-1.3")
    public String getLvl13(Model model) {
        info = levelDescription.getInfo1x3();
        mission = levelDescription.getMission1x3();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-1.3";
    }

    @PostMapping("/lvl-1.3")
    public String postLvl13(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.3", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.3");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-1.3";
    }

    @GetMapping("/lvl-1.4")
    public String getLvl14(Model model) {
        info = levelDescription.getInfo1x4();
        mission = levelDescription.getMission1x4();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", "Neutral");
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-1.4";
    }

    @PostMapping("/lvl-1.4")
    public String postLvl14(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.4", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.4");
        }
        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-1.4";
    }

    @GetMapping("/lvl-2.0")
    public String getLvl3(Model model) {
        info = levelDescription.getInfo2x0();
        mission = levelDescription.getMission2x0();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", "Neutral");
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-2.0";
    }

    @PostMapping("/lvl-2.0")
    public String postLvl3(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("2.0", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("2.0");
        }
        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-2.0";
    }

    @GetMapping("/lvl-2.1")
    public String getLvl2(Model model) {
        info = levelDescription.getInfo2x1();
        mission = levelDescription.getMission2x1();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", "Neutral");
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-2.1";
    }

    @PostMapping("/lvl-2.1")
    public String postLvl2(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("2.1", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("2.1");
        }
        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-2.1";
    }

    @GetMapping("/lvl-3.0")
    public String getLvl4(Model model) {
        info = levelDescription.getInfo3x0();
        mission = levelDescription.getMission3x0();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", "Neutral");
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-3.0";
    }

    @PostMapping("/lvl-3.0")
    public String postLvl4(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("3.0", sqlQuery);
        List<Object> answerList = null;
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("3.0");
        }
        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-3.0";
    }

    @GetMapping("/lvl-4.0")
    public String getLvl5(Model model) {
        info = levelDescription.getInfo4x0();
        mission = levelDescription.getMission4x0();
        tableDescription = levelDescription.getHeroTable();
        model.addAttribute("answerStatus", "Neutral");
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("tableDescription", tableDescription);
        return "lvl-4.0";
    }

    @PostMapping("/lvl-4.0")
    public String postLvl5(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("4.0", sqlQuery);
        List<Object> answerList = null;
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("4.0");
        }
        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        model.addAttribute("info", info);
        model.addAttribute("mission", mission);
        model.addAttribute("playerAnswer", sqlQuery);
        return "lvl-4.0";
    }

    @GetMapping("/game-finished")
    public String gameFinished(Model model) {

        return "game-finished";
    }
}
