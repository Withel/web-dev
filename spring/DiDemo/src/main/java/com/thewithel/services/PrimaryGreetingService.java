package com.thewithel.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
// @Primary tells us that if there is more than one bean I want to use this one
// by making it default were telling spring to use that one if none is
// selected in application.properties
// The default profile is only active when others are not active
@Profile({"en", "default"})
@Primary
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello - from the primary Greeting service";
    }
}
