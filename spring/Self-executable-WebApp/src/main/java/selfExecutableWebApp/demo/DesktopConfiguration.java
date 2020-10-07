package selfExecutableWebApp.demo;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
@AllArgsConstructor
public class DesktopConfiguration {

    private ApplicationContext appContext;

    // Add a tray icon to stop the app:
    @Bean
    public void openTrayIcon() throws Exception {
        try {
            TrayIcon icon = new TrayIcon(new ImageIcon(this.getClass().getResource("/spring.png")).getImage());
            icon.setImageAutoSize(true);
            icon.addActionListener(e -> {
                System.out.println("Exiting app ...");
                SystemTray.getSystemTray().remove(icon);
                SpringApplication.exit(appContext);
            });
            SystemTray.getSystemTray().add(icon);
            icon.displayMessage("Spring Boot", "Application started", TrayIcon.MessageType.INFO);
        } catch (HeadlessException e) {
            System.out.println("Wyjątek związany z ikoną");
        }
    }
}