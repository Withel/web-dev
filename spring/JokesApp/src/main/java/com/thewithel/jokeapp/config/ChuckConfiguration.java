package com.thewithel.jokeapp.config;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

// commenting out @Configuration and @Bean because were moving to xml config
//@Configuration
public class ChuckConfiguration {

    //@Bean
    public ChuckNorrisQuotes chuckNorrisQuotes(){
        return new ChuckNorrisQuotes();
    }
}
