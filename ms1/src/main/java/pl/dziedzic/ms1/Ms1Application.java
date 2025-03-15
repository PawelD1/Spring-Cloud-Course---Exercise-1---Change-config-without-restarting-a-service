package pl.dziedzic.ms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableDiscoveryClient - required in old projects
public class Ms1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ms1Application.class, args);
    }

}
