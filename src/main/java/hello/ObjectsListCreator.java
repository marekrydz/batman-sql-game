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
        Address address;
        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery.trim());
        List<String> names = new ArrayList<>(resultMultimapFromDb.get("name"));
        List<String> emails = new ArrayList<>(resultMultimapFromDb.get("email"));
        List<String> street = new ArrayList<>(resultMultimapFromDb.get("street"));
        List<String> number = new ArrayList<>(resultMultimapFromDb.get("house_number"));

        System.out.println("names" + names.size());
        System.out.println("emails" + emails.size());
        System.out.println("dbRepository.numberOfRowsFromDB" + dbRepository.numberOfRowsFromDB);

        //Created users objects from lists and add to users list
        for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
            address = objectsCreator.createAddressesObjectFromList(i, street, number);
            users.add(objectsCreator.createUserObjectFromList(i, names, emails, address));
        }
        dbRepository.numberOfRowsFromDB = 0;

        System.out.print("1" + users.toString());
        return users;
    }
}