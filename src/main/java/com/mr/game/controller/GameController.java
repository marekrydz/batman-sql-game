package com.mr.game.controller;

import com.mr.game.model.AnswerStatusEnum;
import com.mr.game.service.AnswerService;
import com.mr.game.service.CheckService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    @Resource
    CheckService checkService;

    private String answerStatus;

    @Resource
    AnswerService answerService;

    @GetMapping("/")
    public String welcome() {
        return "welcome-screen";
    }

    @PostMapping("/instruction")
    public String postInstruction() {
        return "instruction";
    }

    @GetMapping("/instruction")
    public String getInstruction() {
        return "instruction";
    }

    @GetMapping("/lvl-1.0")
    public String getLvl11(Model model) {
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        return "lvl-1.0";
    }

    @PostMapping("/lvl-1.0")
    public String postLvl11(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.0", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.0");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-1.0";
    }

    @GetMapping("/lvl-1.1")
    public String getLvl1(Model model) {
        model.addAttribute("answerStatus", "Neutral");
        return "lvl-1.1";
    }

    @PostMapping("/lvl-1.1")
    public String postLvl1(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.1", sqlQuery);
        List<Object> answerList = null;
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.1");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-1.1";
    }

    @GetMapping("/lvl-1.2")
    public String getLvl12(Model model) {
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        return "lvl-1.2";
    }

    @PostMapping("/lvl-1.2")
    public String postLvl12(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.2", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.2");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-1.2";
    }

    @GetMapping("/lvl-1.3")
    public String getLvl13(Model model) {
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        return "lvl-1.3";
    }

    @PostMapping("/lvl-1.3")
    public String postLvl13(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.3", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.3");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-1.3";
    }

    @GetMapping("/lvl-1.4")
    public String getLvl14(Model model) {
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        return "lvl-1.4";
    }

    @PostMapping("/lvl-1.4")
    public String postLvl14(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("1.4", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("1.4");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-1.4";
    }

    @GetMapping("/lvl-2.0")
    public String getLvl3(Model model) {
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        return "lvl-2.0";
    }

    @PostMapping("/lvl-2.0")
    public String postLvl3(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("2.0", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("2.0");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-2.0";
    }

    @GetMapping("/lvl-2.1")
    public String getLvl2(Model model) {
        model.addAttribute("answerStatus", AnswerStatusEnum.Neutral.name());
        return "lvl-2.1";
    }

    @PostMapping("/lvl-2.1")
    public String postLvl2(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("2.1", sqlQuery);
        List<Object> answerList = new ArrayList<>();
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("2.1");
        }

        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-2.1";
    }

    @GetMapping("/lvl-3.0")
    public String getLvl4(Model model) {
        model.addAttribute("answerStatus", "Neutral");
        return "lvl-3.0";
    }

    @PostMapping("/lvl-3.0")
    public String postLvl4(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("3.0", sqlQuery);
        List<Object> answerList = null;
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("3.0");
        }
        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-3.0";
    }

    @GetMapping("/lvl-4.0")
    public String getLvl5(Model model) {
        model.addAttribute("answerStatus", "Neutral");
        return "lvl-4.0";
    }

    @PostMapping("/lvl-4.0")
    public String postLvl5(Model model, @RequestParam String sqlQuery) {
        answerStatus = checkService.isAnswerCorrect("4.0", sqlQuery);
        List<Object> answerList = null;
        if (answerStatus.equals("CorrectAnswer")) {
            answerList = answerService.getCorrectAnswer("4.0");
        }
        model.addAttribute("answerList", answerList);
        model.addAttribute("answerStatus", answerStatus);
        return "lvl-4.0";
    }
}

//
//    private void isAnswerCorrectTest() {
//        //Given
//        String lvl = "14";
//        Answer answer = answerRepository.getAnswerByGameLvl(lvl);
//
//        Statement stmt = dbConnection.getConnectionToDb("jdbc:postgresql://localhost:5432/postgres", "postgres", "marek");
//        ResultSet resultSet;
//
//        try {
//            String sqlQueryFromDB = answer.getAnswerSql();
//            resultSet = stmt.executeQuery(sqlQueryFromDB);
//            ResultSetMetaData rsmd = resultSet.getMetaData();
//            int columnsNumber = rsmd.getColumnCount();
//            System.out.println("*****Result from sql query*****");
//            while (resultSet.next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) ;
//                    String columnValue = resultSet.getString(i);
//                    System.out.print(columnValue + "--");
//                }
//                System.out.println("");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        SessionFactory factory = HibernateUtility.getSessionFactory();
//        Session session = factory.openSession();
//
////        rows[0]+ " -- " +rows[1] + "--"+rows[2]+"--"+rows[3]
//        Query qry = session.createQuery(answer.getAnswerHql());
//        List l = qry.list();
//        Iterator it = l.iterator();
//        System.out.println("*****Result from HQL query*****");
//        while (it.hasNext()) {
//            Object rows[] = (Object[]) it.next();
//            System.out.println(rows[0] + " -- " + rows[1] + rows[2] + " -- " + rows[3]);
//        }
//        session.clear();
//        session.close();
//
//    }