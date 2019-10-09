package hello;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    Creator creator = new Creator();
    DbConnection dbConnection = new DbConnection();

    List getResultFromDBToList(String sqlQuery) {
        int numberOfRowsFromDB = 0;
        List<User> users = new ArrayList<>();
//        String url = "jdbc:postgresql://localhost:5432/postgres";
        ResultSet rs;

//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url, "postgres", "marek");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "marek";
        try {
            Multimap<String, String> multiMap = ArrayListMultimap.create();
            Statement stmt = dbConnection.connectToPostgreSQL(url, user,password);
            rs = stmt.executeQuery(sqlQuery);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            List<String> columnNamesList = new ArrayList<>();
            for (int i = 1; i < columnCount + 1; i++) {
                columnNamesList.add(resultSetMetaData.getColumnName(i));
            }
            while (rs.next()) {
                numberOfRowsFromDB++;
                for (String columnName : columnNamesList) {
                    multiMap.put(columnName, rs.getString(columnName));
                }
            }

            List<String> names = new ArrayList<>(multiMap.get("name"));
            List<String> emails = new ArrayList<>(multiMap.get("email"));

            //Created user object from lists and add to users list
            for (int i = 0; i < numberOfRowsFromDB; i++) {
                users.add(creator.createUserObjectFromList(i, names, emails));
            }
            dbConnection.conn.close();
        } catch (SQLException e) {
            System.out.println("Empty sql query to DB");
            e.printStackTrace();
        }
        System.out.print("1" + users.toString());
        return users;
    }
}