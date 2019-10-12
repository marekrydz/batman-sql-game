package hello;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsCreator {

    public User createUserObjectFromList(int listElement, List<String> names,
                                         List<String> emails, Address address) {
        User user = new User();

        if (!address.equals(null) || !address.street.equals("") || address.houseNumber.equals("")) {
            user.setAddress(address);
        }
        if (!names.isEmpty()) {
            user.setName(names.get(listElement));
        }
        if (!emails.isEmpty()) {
            user.setEmail(emails.get(listElement));
        }
        return user;
    }

    public Address createAddressesObjectFromList(int listElement, List<String> street, List<String> houseNumber) {
        Address address = new Address();
        if (!street.isEmpty()) {
            address.setStreet(street.get(listElement));
        }
        if (!houseNumber.isEmpty()) {
            address.setHouseNumber(houseNumber.get(listElement));
        }
        return address;
    }
}
