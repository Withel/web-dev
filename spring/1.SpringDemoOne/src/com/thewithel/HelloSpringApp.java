package com.thewithel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve bean from spring container
        //when we get the bean we get it fully assembled. Remeber
        //that spring factory will create all the appropriate beans and
        //dependencies and inject those dependencies so you can
        //make use of them
        Coach theCoach = context.getBean("myCoach", Coach.class);

        //call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        //lest call our new method for fortunes
        System.out.println(theCoach.getDailyFortune());

        //close the context
        context.close();
    }
}
