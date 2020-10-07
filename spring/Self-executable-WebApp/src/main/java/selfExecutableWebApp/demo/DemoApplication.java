package selfExecutableWebApp.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // SpringApplication.run(DemoApplication.class, args);
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(DemoApplication.class).headless(false).run(args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void openBrowserAfterStartup() throws IOException, URISyntaxException {
    try {
        Desktop.getDesktop().browse(new URI("http://localhost:8080/main/mainPage"));
    }
    catch (HeadlessException e){
        System.out.println("Obsługa błędu konieczna do tesów jednostkowych");
    }
    }
}
