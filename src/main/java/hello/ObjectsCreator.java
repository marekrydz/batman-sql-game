package hello;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsCreator {

    public User createUserObjectFromList(int listElement, List<String> names,List<String> emails){
        User user = new User();
        if (names.isEmpty()) {
            user.setEmail(emails.get(listElement));
        } else if (emails.isEmpty()) {
            user.setName(names.get(listElement));
        } else {
            user.setEmail(emails.get(listElement));
            user.setName(names.get(listElement));
        }
        return user;
    }
}
