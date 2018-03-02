package org.orh.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Log4j2Application {

    Logger logger = LogManager.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }

    @RequestMapping("/test")
    public String test() {
        logger.info("test access");
        return "hi";
    }
}
