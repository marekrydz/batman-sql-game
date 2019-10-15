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
        List<Hero> heroes = new ArrayList<>();
        BecomeStory becomeStory;
        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery.trim());
        List<String> names = new ArrayList<>(resultMultimapFromDb.get("name"));
        List<String> emails = new ArrayList<>(resultMultimapFromDb.get("real_name"));
        List<String> street = new ArrayList<>(resultMultimapFromDb.get("place"));
        List<String> number = new ArrayList<>(resultMultimapFromDb.get("how"));

        //Created heroes objects from lists and add to heroes list
        for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
            becomeStory = objectsCreator.createAddressesObjectFromList(i, street, number);
            heroes.add(objectsCreator.createUserObjectFromList(i, names, emails, becomeStory));
        }
        dbRepository.numberOfRowsFromDB = 0;

        System.out.print("Result:" + heroes.toString());
        return heroes;
    }
}