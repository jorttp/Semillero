package co.edu.uco.reactiveexample.initiallizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.reactiveexample"})
public class ReactiveexampleApplication {


    public static void main(String[] args) {
        SpringApplication.run(ReactiveexampleApplication.class, args);
    }

}
