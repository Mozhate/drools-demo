package com.laher.drools.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 *
 * @author laher
 * @version 1.0.0
 */
@SpringBootApplication(scanBasePackages = "com.laher")
@ComponentScan(value = {"org.kie.*.**", "com.laher.*.**"})
public class DroolsSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(DroolsSpringBootApplication.class, args);
    }
}
