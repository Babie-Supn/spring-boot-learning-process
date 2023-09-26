package pres.atbabie.logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pres.atbabie")
public class Boot303LoggingApplication {

    public static void main(String[] args) {

        SpringApplication.run(Boot303LoggingApplication.class, args);
    }

}
