package selfExecutableWebApp.demo.user.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class UserDTO {
    private final Long internalId;
    private final UUID id;
    private final String username;
    private final String encodedPassword;
}
