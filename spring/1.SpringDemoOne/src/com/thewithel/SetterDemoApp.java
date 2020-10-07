package com.thewithel;

import javafx.beans.binding.When;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // call methods on the bean
        // ... let's come back to this
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());

        // call our new methods to get the literal values
        // you cant call methods that aren't in theCoach interface if
        // youve created object with that
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeam());

        //second coach for reading values from config file
        System.out.println();

        CricketCoach theSecondCoach = context.getBean("mySecondCricketCoach", CricketCoach.class);
        System.out.println(theSecondCoach.getDailyFortune());
        System.out.println(theSecondCoach.getDailyWorkout());
        System.out.println(theSecondCoach.getTeam());
        System.out.println(theSecondCoach.getEmailAddress());

        // close the context
        context.close();

        // ================================================

        // When you write .class after a class name, it references the class literal
        // - java.lang.Class object that represents information about given class.
        // For example, if your class is Print, then CricketCoach.class is an object that represents
        // the class CricketCoach on runtime. It is the same object that is returned by the getClass()
        // method of any (direct) instance of CricketCoach.

        System.out.println();
        CricketCoach coach = new CricketCoach();
        System.out.println(CricketCoach.class.getName());
        System.out.println(coach.getClass().getName());
    }
}
