package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class GameController {

    @Resource
    ObjectsListCreator objectsListCreator;

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String main() {
        return "welcome";
    }

    @PostMapping("/")
    public String mainSubmit(Model model, @RequestParam String sqlQuery) {

        List<Hero> heroes = objectsListCreator.createHeroesList(sqlQuery);
        List<BecomeStory> becomeStories = objectsListCreator.createBecomeStoriesList(sqlQuery);
        List<Weapon>weapons = objectsListCreator.createdWeaponsList(sqlQuery);
        List<Enemy>enemies = objectsListCreator.createdEnemiesList(sqlQuery);
        model.addAttribute("heroes", heroes);
        model.addAttribute("weapons", weapons);
        model.addAttribute("becomeStories", becomeStories);
        model.addAttribute("enemies", enemies);
        return "welcome";
    }

    @GetMapping("/add")
    public String add() {

        return "welcome";
    }

    @GetMapping("/showAll")
    public String showAll() {
        return "welcome";
    }
}
