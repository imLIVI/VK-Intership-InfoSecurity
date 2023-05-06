package vk.security.vkintershipinfosecurity.service;

import vk.security.vkintershipinfosecurity.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private final int NUM_USERS = 10;
    private final String NAME = "user-";
    private final String PASSWORD = "qwerty_";
    private Map<Person, List<AuthorizationService.Authorities>> usersList;

    public UserRepository() {
        usersList = new HashMap<>();
        for (int i = 0; i < NUM_USERS; i++) {
            usersList.put(new Person(NAME + i,
                    PASSWORD + i),
                    getAuthorization());
        }
    }

    private List<AuthorizationService.Authorities> getAuthorization() {
        List<AuthorizationService.Authorities> list = new ArrayList<>();
        int len = AuthorizationService.Authorities.values().length;

        for (int i = 0; i < Math.random() * len; i++) {
            int rand = (int) (Math.random() * len);
            if (!list.contains(AuthorizationService.Authorities.values()[rand]))
                list.add(AuthorizationService.Authorities.values()[rand]);
        }
        return list;
    }

    public List<AuthorizationService.Authorities> getUserAuthorities(String user, String password) {
        for(Map.Entry person : usersList.entrySet()) {
            Person p = (Person) person.getKey();
            if (p.getUser().equals(user) && p.getPassword().equals(password))
                return (List<AuthorizationService.Authorities>) person.getValue();
        }
        return null;
    }
}