package com.mr.game.controller;

import com.mr.game.creator.ObjectsListCreator;
import com.mr.game.model.*;
import com.mr.game.service.Check;
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
    Check check;


    String isCorrect;

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

    @PostMapping("/introduction")
    public String postIntroduction(Model model, @RequestParam String sqlQuery) {
        isCorrect = check.isCorrectAnswer(1, sqlQuery);
        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("isCorrect", isCorrect);


        return "introduction";
    }

    @GetMapping("/introduction")
    public String getIntroduction(Model model) {
        isCorrect = AnswerEnum.Neutral.name();
        List<Hero> heroes = Collections.emptyList();
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("isCorrect", isCorrect);

        return "introduction";
    }

    @PostMapping("/lvl2")
    public String postLvl2(Model model, @RequestParam String sqlQuery) {
        isCorrect = check.isCorrectAnswer(2, sqlQuery);
        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = objectsListCreator.createBecomeStoriesList(sqlQuery);
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("isCorrect", isCorrect);


        return "lvl2";
    }

    @GetMapping("/lvl2")
    public String getLvl2(Model model) {
        isCorrect = AnswerEnum.Neutral.name();
        List<Hero> heroes = Collections.emptyList();
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("isCorrect", isCorrect);

        return "lvl2";
    }

    @PostMapping("/lvl3")
    public String postLvl3(Model model, @RequestParam String sqlQuery) {

        isCorrect = check.isCorrectAnswer(3, sqlQuery);
        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = objectsListCreator.createBecomeStoriesList(sqlQuery);
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("isCorrect", isCorrect);


        return "lvl3";
    }

    @GetMapping("/lvl3")
    public String getLvl3(Model model) {
        isCorrect = AnswerEnum.Neutral.name();
        List<Hero> heroes = Collections.emptyList();
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        model.addAttribute("isCorrect", isCorrect);

        return "lvl3";
    }



    @GetMapping("/showAll")
    public String showAll() {
        return "introduction";
    }
}
