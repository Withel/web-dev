package com.thewithel.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
// when spring has two primary services it will ignore the one with the
// profile if it's not active
// we configure profiles in application.properties
// if we have one service marked as @Primary, and then we add another
// with @Profile Spring will complain about it, so we need to mark
// this other @Primary with some @Profile annotation
@Profile("es")
@Primary
public class PrimarySpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Servicio de Saludo Primario";
    }
}
