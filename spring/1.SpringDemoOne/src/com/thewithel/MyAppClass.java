package com.thewithel;

public class MyAppClass {

    public static void main(String[] args) {


        //create the object
        Coach theCoach = new TrackCoach(() -> "Im annonymous class. Hi there");

        //use the object
        System.out.println(theCoach.getDailyWorkout());
    }
}
