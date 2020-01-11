package com.mr.game.controller;

import com.mr.game.creator.ObjectsListCreator;
import com.mr.game.model.*;
import com.mr.game.service.CheckService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Controller
public class GameController {

    @Resource
    ObjectsListCreator objectsListCreator;

    @Resource
    CheckService checkService;

    String answerStatus;

    @GetMapping("/")
    public String welcome(Model model) {
        return "welcome-screen";
    }

    @PostMapping("/instruction")
    public String postInstruction() {
        return "instruction";
    }

    @GetMapping("/instruction")
    public String getInstruction(Model model) {
        return "instruction";
    }

    @GetMapping("/lvl1")
    public String getLvl1(Model model) {
        List<Hero> heroes = Collections.emptyList();
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        return "lvl1";
    }

    @PostMapping("/lvl1")
    public String postLvl1(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect(1,sqlQuery);
        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl1";
    }



    @GetMapping("/lvl2")
    public String getLvl2(Model model) {
        List<Hero> heroes = Collections.emptyList();
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());

        return "lvl2";
    }

    @PostMapping("/lvl2")
    public String postLvl2(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect(2,sqlQuery);
        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = objectsListCreator.createBecomeStoriesList(sqlQuery);
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("answerStatus", answerStatus);


        return "lvl2";
    }

    @GetMapping("/lvl3")
    public String getLvl3(Model model) {
        List<Hero> heroes = Collections.emptyList();
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        return "lvl3";
    }

    @PostMapping("/lvl3")
    public String postLvl3(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect(3,sqlQuery);
        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = objectsListCreator.createBecomeStoriesList(sqlQuery);
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl3";
    }



    @GetMapping("/showAll")
    public String showAll() {
        return "lvl1";
    }
}
