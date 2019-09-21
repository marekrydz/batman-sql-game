package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String main(Model model) {

        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome";
    }

    @GetMapping("/add")
    public String add() {
        repository.save(new User("Anna", "anna@gmail.com"));
        return "welcome";
    }

//    @GetMapping("/getAll")
//    public String getAll() {
//        repository.save(new User("Kochaniasta2", "anna.kochaniasta@gmail.com2"));
//        return "welcome";
//    }
}
