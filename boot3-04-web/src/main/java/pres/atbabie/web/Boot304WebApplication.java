package pres.atbabie.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "pres.atbabie")

@SpringBootApplication
public class Boot304WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot304WebApplication.class, args);
    }

}
