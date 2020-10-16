package com.laher.drools.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
@SpringBootApplication(scanBasePackages = "com.laher")
public class DroolsSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(DroolsSpringBootApplication.class, args);
    }
}
