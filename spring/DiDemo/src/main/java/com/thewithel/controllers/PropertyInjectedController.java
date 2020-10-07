package com.thewithel.controllers;

import com.thewithel.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    // here were asking spring to incject that
    // we can do that because name of the property is the bean name
    // but if you have @Primary above some of the services it will
    // implement that one
//    @Autowired
//    public GreetingService greetingServiceImpl;

    @Autowired
    @Qualifier("greetingServiceImpl")
    public GreetingService greetingServiceImpl;

    public String sayHello(){
        return greetingServiceImpl.sayGreeting();
    }
}
