package vk.security.vkintershipinfosecurity.service;

import org.springframework.stereotype.Service;
import vk.security.vkintershipinfosecurity.exceptions.InvalidCredentials;
import vk.security.vkintershipinfosecurity.exceptions.UnauthorizedUser;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public enum Authorities {
        READ, WRITE, DELETE
    }

    public AuthorizationService() {
        this.userRepository = new UserRepository();
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
