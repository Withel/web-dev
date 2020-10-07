package selfExecutableWebApp.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping("/mainPage")
    public String mainPage(){       //TODO: Refactor
        return "main/mainPage";
    }
}
