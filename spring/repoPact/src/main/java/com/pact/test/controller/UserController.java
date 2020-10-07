package com.pact.test.controller;


import com.pact.test.model.User;
import com.pact.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "home";
    }

    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public @ResponseBody String changeData(@RequestParam("userID") String id,@RequestParam("username") String username,
                                           @RequestParam("password") String password,@RequestParam("oldUsername") String oldUsername){
        userService.modifyUser(id,username,password,oldUsername);
        return "showUsers";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestParam("userID") String id,@RequestParam("username") String username,
                                           @RequestParam("password") String password){
        userService.addUser(id,username,password);
        return "showUsers";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public @ResponseBody String deleteUser(@RequestParam("userID") String id,@RequestParam("username") String username){
        userService.deleteUser(id,username);
        return "showUsers";
    }

    @RequestMapping(value = "/testlist", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAjax(@RequestParam("selectedParam") String selectedParam,@RequestParam("selectedValue") String selectedValue,
                       @RequestParam("passwordFilter") String passwordFilter,@RequestParam("usernameFilter") String usernameFilter) {
        userService.addSQLParams(selectedParam,selectedValue,usernameFilter,passwordFilter);
        return userService.getAllUsers();
    }
}
