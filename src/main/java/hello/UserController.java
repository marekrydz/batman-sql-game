package hello;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.lang.reflect.Array;
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
    public String main(Model model) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Connection conn = DriverManager.getConnection(url, "postgres", "marek");
        String sql = "SELECT name FROM users ";
        Map<String, List<String>> columnNameToValuesMap = new HashMap<>();
        Multimap<String, String> map = ArrayListMultimap.create();
        String key1 = "name";
        String key2 = "email";

        map.put(key1,"Marek");
        map.put(key1,"Ania");
        map.put(key2,"@1");
        map.put(key2,"@2");
        map.put(key1,"Marek");
        map.put(key1,"Ania");
        map.put(key2,"@1");
        map.put(key2,"@2");

        System.out.print(map.toString());

System.out.print("Size get key" + map.keys().size());
System.out.print("get key" + map.keySet());
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            List<String> columnNames = new LinkedList<>();
            int columnsNumber = resultSetMetaData.getColumnCount();

            for(int i = 1; i<=columnsNumber; i++){
                String columnName = resultSetMetaData.getColumnName(i);
                columnNames.add(columnName);
                columnNameToValuesMap.put(columnName, new ArrayList());
            }

            while (rs.next()) {
                for(String columnName: columnNames){
                    List<String>columnDataList = columnNameToValuesMap.get(columnName);

                    columnDataList.add(rs.getString(columnName));
                    columnNameToValuesMap.put(columnName,columnDataList);
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        model.addAttribute("users", repository.findAll());
        model.addAttribute("answers",map.keySet());
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
