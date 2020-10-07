package selfExecutableWebApp.demo.user.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import selfExecutableWebApp.demo.user.dto.CreateUserDTO;
import selfExecutableWebApp.demo.user.model.UserFacade;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserFacade userFacade;

    @PostMapping("/register")
    String registerUser(@ModelAttribute CreateUserDTO createUserDto) {
        userFacade.create(createUserDto);
        return "redirect:/user/registered";
    }

    @GetMapping("/register")
    String registerPage(Model model) {
        model.addAttribute("createUser", new CreateUserDTO());
        return "user/register";
    }

    @GetMapping("/registered")
    String registered() {
        return "user/registered";
    }
}
