package hello;

import com.google.common.collect.Multimap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ObjectsListCreator {
    private ObjectsCreator objectsCreator = new ObjectsCreator();
    private DbRepository dbRepository = new DbRepository();

    List createHeroesList(String sqlQuery) {
        List<Hero> heroes = new ArrayList<>();
        BecomeStory becomeStory;
        Set<Weapon> weapons = new HashSet<>();

        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery.trim());
        List<String> names = new ArrayList<>(resultMultimapFromDb.get("name"));
        List<String> emails = new ArrayList<>(resultMultimapFromDb.get("real_name"));

        //Created heroes objects from lists and add to heroes list
        for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
            heroes.add(objectsCreator.createHeroObjectFromRepo(i, names, emails));
        }
        dbRepository.numberOfRowsFromDB = 0;

        System.out.print("Result:" + heroes.toString());
        System.out.print("Result:" + weapons.toString());
        return heroes;
    }

    List createBecomeStoriesList(String sqlQuery) {
        List<BecomeStory> becomeStories = new ArrayList<>();
        BecomeStory becomeStory;
        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery.trim());
        List<String> how = new ArrayList<>(resultMultimapFromDb.get("how"));
        List<String> place = new ArrayList<>(resultMultimapFromDb.get("place"));

        //Created heroes objects from lists and add to heroes list
        for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
            becomeStory = objectsCreator.createBecomeStoryObjectFromList(i, place, how);
            becomeStories.add(becomeStory);
        }
        dbRepository.numberOfRowsFromDB = 0;
        return becomeStories;
    }

    List<Weapon> createdWeaponsList(String sqlQuery) {
        List<Weapon> weapons = new ArrayList<>();
        Weapon weapon;
        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery.trim());

        List<String> weaponName = new ArrayList<>(resultMultimapFromDb.get("weapons_names"));
        List<String> characteristic = new ArrayList<>(resultMultimapFromDb.get("characteristic"));

        for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
            weapon = objectsCreator.createWeaponObjectFromList(i,weaponName,characteristic);
            weapons.add(weapon);
        }
        dbRepository.numberOfRowsFromDB = 0;
        return weapons;
    }
}