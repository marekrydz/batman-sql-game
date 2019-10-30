package hello;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String welcome(Model model) {
        String mainContent = "Where is Mimis";
        model.addAttribute("mainContent", mainContent);
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
        gameLvl++;

        boolean isCorrect = check.isCorrectAnswer(1, sqlQuery);

        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);


        return "introduction";
    }

    @GetMapping("/introduction")
    public String getIntroduction(Model model) {
        List<Hero> heroes = Collections.emptyList();
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        return "introduction";
    }

    @GetMapping("/showAll")
    public String showAll() {
        return "introduction";
    }
}
