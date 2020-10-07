package selfExecutableWebApp.demo.user.model;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import selfExecutableWebApp.demo.user.dto.CreateUserDTO;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CreateService {

    private final PasswordEncoder passwordEncoder;
    private final UserAccountRepository repository;


    UserAccount createUser(CreateUserDTO dto) {
        UserAccount newAccount = new UserAccount(UUID.randomUUID());
        newAccount.setUsername(dto.getUsername());
        newAccount.setPassword(passwordEncoder.encode(dto.getPassword()));
        repository.save(newAccount);
        return newAccount;
    }
}
