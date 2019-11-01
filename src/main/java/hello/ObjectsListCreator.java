package hello;

import com.google.common.collect.Multimap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectsListCreator {
    private ObjectsCreator objectsCreator = new ObjectsCreator();
    private DbRepository dbRepository = new DbRepository();

    List createHeroesList(String sqlQuery) {
        List<Hero> heroes = new ArrayList<>();

        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery.trim());
        List<String> names = new ArrayList<>(resultMultimapFromDb.get("name"));
        List<String> emails = new ArrayList<>(resultMultimapFromDb.get("real_name"));

        //Created heroes objects from lists and add to heroes list
        if (names.size() != 0 || emails.size() != 0) {
            for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
                heroes.add(objectsCreator.createHeroObjectFromRepo(i, names, emails));
            }
        }
        dbRepository.numberOfRowsFromDB = 0;
        System.out.print("Result:" + heroes.toString());
        return heroes;
    }

    List createBecomeStoriesList(String sqlQuery) {
        List<BecomeStory> becomeStories = new ArrayList<>();
        BecomeStory becomeStory;
        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery.trim());
        List<String> how = new ArrayList<>(resultMultimapFromDb.get("how"));
        List<String> place = new ArrayList<>(resultMultimapFromDb.get("place"));

        //Created heroes objects from lists and add to heroes list
        if (how.size() != 0 || place.size() != 0) {
            for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
                becomeStory = objectsCreator.createBecomeStoryObjectFromList(i, place, how);
                becomeStories.add(becomeStory);
            }
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
        if (weaponName.size() != 0 || characteristic.size() != 0) {
            for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
                weapon = objectsCreator.createWeaponObjectFromList(i, weaponName, characteristic);
                weapons.add(weapon);
            }
        }
        System.out.print("Result:" + weapons.toString());
        dbRepository.numberOfRowsFromDB = 0;
        return weapons;
    }

    List<Enemy> createdEnemiesList(String sqlQuery) {
        List<Enemy> enemies = new ArrayList<>();
        Enemy enemy;
        Multimap resultMultimapFromDb = dbRepository.getSqlQueryResultFromDBToMultimap(sqlQuery.trim());

        List<String> nick = new ArrayList<>(resultMultimapFromDb.get("nick"));
        List<String> enemyRealName = new ArrayList<>(resultMultimapFromDb.get("enemy_real_name"));

        if (nick.size() != 0 || enemyRealName.size() != 0) {
            for (int i = 0; i < dbRepository.numberOfRowsFromDB; i++) {
                enemy = objectsCreator.createEnemyObjectFromList(i, nick, enemyRealName);
                enemies.add(enemy);
            }
        }
        dbRepository.numberOfRowsFromDB = 0;
        return enemies;
    }
}