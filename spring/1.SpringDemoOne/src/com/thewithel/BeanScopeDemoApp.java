package com.thewithel;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {

        // load the spring confguration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // check if they are the same bean
        boolean result = theCoach.equals(alphaCoach);
        boolean result2 = (theCoach == alphaCoach);

        System.out.println("Pointing to the same object, with equals = " + result);
        System.out.println("Pointing to the same object, with '==' = " + result2);
        System.out.println("\nMemory location for theCoach: " + theCoach);
        System.out.println("\nMemory location for theCoach: " + alphaCoach);

        // close the context
        context.close();
    }
}
