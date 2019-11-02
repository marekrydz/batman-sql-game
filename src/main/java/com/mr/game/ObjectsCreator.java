package com.mr.game;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsCreator {

    public Hero createHeroObjectFromRepo(int listElement, List<String> names,
                                         List<String> emails) {
        Hero hero = new Hero();

        if (!names.isEmpty()) {
            hero.setName(names.get(listElement));
        }
        if (!emails.isEmpty()) {
            hero.setRealName(emails.get(listElement));
        }
        return hero;
    }

    public BecomeStory createBecomeStoryObjectFromList(int listElement, List<String> place, List<String> how) {

        BecomeStory becomeStory = new BecomeStory();

        if (!place.isEmpty()) {
            becomeStory.setPlace(place.get(listElement));
        }
        if (!how.isEmpty()) {
            becomeStory.setHow(how.get(listElement));
        }
        return becomeStory;
    }

    public Weapon createWeaponObjectFromList(int listElement, List<String> type, List<String> characteristic) {

        Weapon weapon = new Weapon();

        if (!type.isEmpty()) {
            weapon.setWeaponName(type.get(listElement));
        }
        if (!characteristic.isEmpty()) {
            weapon.setCharacteristic(characteristic.get(listElement));
        }
        return weapon;
    }

    public Enemy createEnemyObjectFromList(int listElement, List<String> nick, List<String> enemyRealName) {

        Enemy enemy = new Enemy();

        if (!nick.isEmpty()) {
            enemy.setNick(nick.get(listElement));
        }
        if (!enemyRealName.isEmpty()) {
            enemy.setEnemyRealName(enemyRealName.get(listElement));
        }
        return enemy;
    }
}