package app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Starting app ...");
        SpringApplication.run(Main.class, args);
        log.info("Started app");
    }
}
