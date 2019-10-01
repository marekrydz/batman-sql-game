package hello;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.sql.*;
import java.util.*;


@Controller
public class UserController {

    @Resource
    private UserRepository repository;

    @Resource
    JdbcTemplate jdbcTemplate;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String main()  {

      return "welcome";
    }

    @PostMapping("/")
    public String mainSubmit(Model model, @RequestParam String sqlQuery)throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection conn = DriverManager.getConnection(url, "postgres", "marek");
        String sql = sqlQuery;

        List<User> users = new ArrayList<>();


        try {
            Multimap<String, String> multiMap = ArrayListMultimap.create();
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            List<String> s1 = new ArrayList<>();
            for (int i = 1; i < columnCount + 1; i++) {
                s1.add(resultSetMetaData.getColumnName(i));
            }
            while (rs.next()) {
                for (int i = 0; i < s1.size(); i++) {
                    multiMap.put(s1.get(i), rs.getString(s1.get(i)));
                }
            }

            List<String> names = new ArrayList<>(multiMap.get("name"));
            List<String> emails = new ArrayList<>(multiMap.get("email"));
            for (int i = 0; i < names.size(); i++) {
                User multisetUser = new User(names.get(i), emails.get(i));

                users.add(multisetUser);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("1"+users.toString());


        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        model.addAttribute("users", repository.findAll());
        model.addAttribute("users", users);

        return "welcome";
    }

    @GetMapping("/add")
    public String add() {
        repository.save(new User("Anna", "anna@gmail.com"));
        return "welcome";
    }

    @GetMapping("/showAll")
    public String showAll() {
        System.out.println(repository.findAll());
        return "welcome";
    }
}
