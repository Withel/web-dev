package com.thewithel.springregistration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

//    public ModelAndView registerUserAccount(
//            @ModelAttribute("user") @Valid UserDto accountDto,
//            BindingResult result, WebRequest request, Errors errors) {
//
//    }
}
