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
import java.util.concurrent.atomic.AtomicLong;


@Controller
public class GreetingController {

    @Autowired
    private Greeting greeting;
    private final AtomicLong counter = new AtomicLong();
    private List<String> tasks = Arrays.asList("a","b","c","d","e","f","g");

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String main(Model model)
    {

        model.addAttribute("message",message);
        model.addAttribute("tasks",tasks);
        model.addAttribute("greetingElem",greeting.getContent());

        return "welcome";
    }
//
//    @GetMapping("/hello")
//    public String mainWithParam(
//            @RequestParam(name = "name", required = false, defaultValue = "")
//                    String name, Model model) {
//
//        model.addAttribute("message", name);
//
//        return "welcome"; //view
//    }
}
