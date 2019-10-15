package hello;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.*;

@Controller
public class UserController {

    @Resource
    ObjectsListCreator objectsListCreator;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String main() {
        return "welcome";
    }

    @PostMapping("/")
    public String mainSubmit(Model model, @RequestParam String sqlQuery)  {

        List<Hero> heroes = objectsListCreator.createUsersList(sqlQuery);

        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        model.addAttribute("heroes", heroes);

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
