package selfExecutableWebApp.demo.user.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import selfExecutableWebApp.demo.user.dto.UserDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class UserAccount {

    @Id
    @GeneratedValue
    private Long dbId;
    private UUID id;
    private String username;
    private String password;

    UserAccount(UUID uuid) {
        this.id = uuid;
    }

    @Override
    public int hashCode() {
        return 7 * 13 * this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return ((obj instanceof UserAccount) && ((UserAccount) obj).id == this.id);
    }


    UserDTO dto(){
        return UserDTO.builder()
                .internalId(dbId)
                .id(id)
                .username(username)
                .encodedPassword(password)
                .build();
    }
}
