package hello;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsCreator {

    public Hero createUserObjectFromList(int listElement, List<String> names,
                                         List<String> emails, BecomeStory becomeStory) {
        Hero hero = new Hero();

        if (!becomeStory.equals(null) || !becomeStory.place.equals("") || becomeStory.how.equals("")) {
            hero.setBecomeStory(becomeStory);
        }
        if (!names.isEmpty()) {
            hero.setName(names.get(listElement));
        }
        if (!emails.isEmpty()) {
            hero.setRealName(emails.get(listElement));
        }
        return hero;
    }

    public BecomeStory createAddressesObjectFromList(int listElement, List<String> street, List<String> houseNumber) {
        BecomeStory becomeStory = new BecomeStory();
        if (!street.isEmpty()) {
            becomeStory.setPlace(street.get(listElement));
        }
        if (!houseNumber.isEmpty()) {
            becomeStory.setHow(houseNumber.get(listElement));
        }
        return becomeStory;
    }
}
