package selfExecutableWebApp.demo.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import selfExecutableWebApp.demo.user.dto.UserDTO;
import selfExecutableWebApp.demo.user.model.UserFacade;

import java.util.Collections;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserFacade userFacade;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDto = userFacade.getByUsername(username);
        return CustomUserDetails.builder()
                .id(userDto.getInternalId())
                .username(userDto.getUsername())
                .password(userDto.getEncodedPassword())
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))) //TODO role from DB
                .build();
    }
}
