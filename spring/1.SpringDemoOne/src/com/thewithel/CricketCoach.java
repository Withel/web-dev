package com.thewithel;

public class CricketCoach implements Coach{


    private FortuneService fortuneService;

    // add new fields for emailAddress and team
    private String emailAddress;
    private String team;

    // create a no-arg constructor because spring will call it
    // when it will create a reference of our bean
    public CricketCoach(){
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    // created setter method that will be called by spring when
    // it will actually inject dependency
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method - setFortuneService()");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - setTeam");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15minutes.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
