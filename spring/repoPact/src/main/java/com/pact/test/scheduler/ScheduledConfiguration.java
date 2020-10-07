package com.pact.test.scheduler;

import com.pact.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Random;

@Configuration
@EnableScheduling
public class ScheduledConfiguration {
    @Autowired
    UserService userService;

    @Scheduled(fixedRate = 9000)
    public void executeTask1() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder UsernameBuffer = new StringBuilder(targetStringLength);
        StringBuilder PasswordBuffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedIntUsername = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            int randomLimitedIntPassword = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            UsernameBuffer.append((char) randomLimitedIntUsername);
            PasswordBuffer.append((char) randomLimitedIntPassword);
        }
        String randomUsername = UsernameBuffer.toString();
        String randomPassword = PasswordBuffer.toString();
        System.out.println(randomPassword+"   "+randomUsername);
        userService.addUser("0", randomUsername, randomPassword);
    }
}