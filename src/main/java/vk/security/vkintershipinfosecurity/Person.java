package vk.security.vkintershipinfosecurity;

public class Person {
    private String user;
    private String password;

    public Person() {

    }

    public Person(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
