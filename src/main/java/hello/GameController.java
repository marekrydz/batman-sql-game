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

    @PostMapping("/game")
    public String game(Model model, @RequestParam String sqlQuery) {

        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = objectsListCreator.createBecomeStoriesList(sqlQuery);
        List<Weapon> weapons = objectsListCreator.createdWeaponsList(sqlQuery);
        List<Enemy> enemies = objectsListCreator.createdEnemiesList(sqlQuery);
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        return "game";
    }

    @GetMapping("/game")
    public String instruction(Model model) {
        List<Hero> heroes = Collections.emptyList();
        List<BecomeStory> becomeStories = Collections.emptyList();
        List<Weapon> weapons = Collections.emptyList();
        List<Enemy> enemies = Collections.emptyList();
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        return "game";
    }

    @GetMapping("/showAll")
    public String showAll() {
        return "game";
    }
}
