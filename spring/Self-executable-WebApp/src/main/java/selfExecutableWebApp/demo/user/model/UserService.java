package selfExecutableWebApp.demo.user.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserService{

    private final UserAccountRepository repository;

    UserAccount get(String username) {
        //TODO specialized exception
        return repository.findByUsername(username).orElseThrow(() ->
                new RuntimeException("User with username: " + username + " not found"));
    }
}
