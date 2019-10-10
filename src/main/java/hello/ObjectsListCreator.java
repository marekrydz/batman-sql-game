package hello;

import com.google.common.collect.Multimap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectsListCreator {
    private ObjectsCreator objectsCreator = new ObjectsCreator();
    private DbRepository dbRepository = new DbRepository();

    List createUsersList(String sqlQuery) {
        List<User> users = new ArrayList<>();
        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery);
        List<String> names = new ArrayList<>(resultMultimapFromDb.get("name"));
        List<String> emails = new ArrayList<>(resultMultimapFromDb.get("email"));

        System.out.println("names" + names.size());
        System.out.println("emails" + emails.size());

        //Created users objects from lists and add to users list
        for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
            users.add(objectsCreator.createUserObjectFromList(i, names, emails));
        }
        dbRepository.numberOfRowsFromDB = 0;

        System.out.print("1" + users.toString());
        return users;
    }
}