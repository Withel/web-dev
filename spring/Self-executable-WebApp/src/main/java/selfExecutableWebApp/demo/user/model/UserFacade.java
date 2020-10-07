package selfExecutableWebApp.demo.user.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import selfExecutableWebApp.demo.user.dto.CreateUserDTO;
import selfExecutableWebApp.demo.user.dto.UserDTO;

@Component
@AllArgsConstructor
public class UserFacade {

    private CreateService createService;
    private UserService userService;

    public void create(CreateUserDTO createUserDto) {
        createService.createUser(createUserDto);
    }

    public UserDTO getByUsername(String username) {
        return userService.get(username).dto();
    }
}
